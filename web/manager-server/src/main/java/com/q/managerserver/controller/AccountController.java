package com.q.managerserver.controller;

import com.q.entity.Account;
import com.q.entity.ResultEntity;
import com.q.managerserver.service.IAccountService;
import com.sun.org.apache.regexp.internal.RE;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Null;
import javax.xml.crypto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@RequestMapping(value = "/account")
@RestController
public class AccountController {

  @Autowired
  private IAccountService iAccountService;


  /**
   * 保证数据完整性,一次最多插入一万
   * @param accountList
   * @return
   */
  @RequestMapping(value = "/importAccount",method = RequestMethod.POST)
  public ResultEntity importAccount(@RequestBody List<Account> accountList) {
    for (Account ac:accountList) {
      ac.setCreateTime(new Date());
    }

    Integer integer;
    try {
      integer = iAccountService.importAccount(accountList);
      return ResultEntity.success("导入数据成功", integer);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResultEntity.fail("数据库异常", null);
  }

    @RequestMapping(value = "/importAccountFile",method = RequestMethod.POST)
  public ResultEntity importAccount(MultipartFile file) {
//    System.out.println("file = [" + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")) + "]");
    if (file != null && file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equals(".txt")) {
      ArrayList<Account> accountList = new ArrayList<>();
      try {
        Reader reader = null;
        reader = new InputStreamReader(file.getInputStream(), "utf-8");
        BufferedReader br = new BufferedReader( reader);
        Date time=new Date();
        String line;
        while ((line = br.readLine()) != null) {
          // 一次读入一行数据
          Account account = new Account();
          String[] split = line.split("----");
          if (split.length == 3 ) {
            account.setAccount(split[0]);
            account.setPassWord(split[1]);
            account.setOtherString(split[2]);
            account.setCreateTime(new Date());
          } else if (split.length == 2) {
            account.setAccount(split[0]);
            account.setPassWord(split[1]);
            account.setCreateTime(new Date());
          }
          accountList.add(account);
        }
        if (accountList.size() == 0) {
          return ResultEntity.fail("文本文件中数据错误,无法提取有效数据", null);
        }
        reader.close();
        Integer result = iAccountService.importAccount(accountList);
        //返回插入数据结果总数
        return ResultEntity.success("导入成功", result);
      } catch (IOException e) {
        System.out.println("发生异常");
        e.printStackTrace();
      }
    }
    return ResultEntity.fail("异常文件,请上传TXT文件",null);
  }

  @PostMapping(value = "/getAccount")
  public ResultEntity getAccount(Integer number) {
    if (number == null) {
      number = 1;
    }
    List<Account> account = iAccountService.getAccount(number);
    System.out.println(account);
    return ResultEntity.success("获取成功", account);
  }
}

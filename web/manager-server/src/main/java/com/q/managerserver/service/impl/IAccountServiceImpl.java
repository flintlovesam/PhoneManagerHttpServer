package com.q.managerserver.service.impl;

import com.q.entity.Account;
import com.q.managerserver.mapper.IAccountMapper;
import com.q.managerserver.service.IAccountService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Service
public class IAccountServiceImpl implements IAccountService {

  @Autowired
  private IAccountMapper iAccountMapper;

  @Value("${MYSQL.insertNumber}")
  private Integer insertNumber;

  /**
   * 获取账号数据
   * @param number
   * @return
   */
  @Override
  @Transactional
  public List<Account> getAccount(Integer number) {
    ReentrantLock lock = new ReentrantLock();

    List<Account> accountList = null;
    try {
      lock.lock();
      accountList = iAccountMapper.getAccount(number);
      ArrayList<Integer> list = new ArrayList<>();
      for (Account ac:accountList) {
        list.add(ac.getId());
      }
      iAccountMapper.update(list,new Date());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return accountList;
  }

  /**
   * 要么全部插入成功，要么全部失败
   * @param accountList
   * @return
   */
  @Transactional
  @Override
  public Integer importAccount(List<Account> accountList) {
    Integer result = 0;
    //循环插入数据
    List<Account> newList = null;
    for (int j=0;j<accountList.size();j++) {
      if (newList == null) {
        newList = new ArrayList<>();

      }
      newList.add(accountList.get(j));
      if ((j % insertNumber==0 && j!=0) || j == accountList.size()-1) {
        result = iAccountMapper.insertList(newList) + result;
        newList = null;
      }
    }
    return result;
  }

}

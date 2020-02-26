package com.q.managerserver.controller;

/**
 * Create by Administrator on 2020/2/25 0025
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.q.entity.LogEntity;
import com.q.entity.ResultEntity;
import com.q.managerserver.service.ILoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class loggerController {

  @Autowired
  private ILoggerService loggerService;

  @PostMapping(value = "/getLogger")
  public ResultEntity getLogger(PageInfo<LogEntity> page) {
    //总数获取
    if (page.getTotal() < 1) {
      Integer total = loggerService.selectCount();
      page.setTotal(total);
      page.setStartRow(0);
      //查询数
      page.setEndRow(10);
      page.setPageNum(total / 10);

    }else {
      page.setStartRow(page.getEndRow());
      page.setEndRow(page.getEndRow() + 10);
    }
    loggerService.getList(page);

    return ResultEntity.success("获取完成", page);
  }

  @RequestMapping(value = "/addLogger")
  public ResultEntity addLogger(String logString, String devicesId) {

    return ResultEntity.success("添加完成", null);
  }
}

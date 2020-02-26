package com.q.managerserver.service;

import com.github.pagehelper.PageInfo;
import com.q.entity.LogEntity;
import java.util.List;

/**
 * Create by Administrator on 2020/2/25 0025
 */
public interface ILoggerService {


  Integer selectCount();

  List<LogEntity> getList(PageInfo<LogEntity> page);
}

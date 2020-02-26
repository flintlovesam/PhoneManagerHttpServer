package com.q.managerserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.q.entity.LogEntity;
import com.q.managerserver.mapper.ILoggerMapper;
import com.q.managerserver.service.ILoggerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Service
public class ILoggerServiceImpl implements ILoggerService {

  @Autowired
  private ILoggerMapper iloggerMapper;

  @Override
  public Integer selectCount() {
    return iloggerMapper.selectCount();
  }

  @Override
  public List<LogEntity> getList(PageInfo<LogEntity> page) {
    iloggerMapper.getList(page);
    return null;
  }
}

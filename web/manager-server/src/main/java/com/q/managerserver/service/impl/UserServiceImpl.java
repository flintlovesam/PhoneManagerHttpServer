package com.q.managerserver.service.impl;

import com.q.entity.User;
import com.q.managerserver.mapper.IUserMapper;
import com.q.managerserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserMapper userMapper;

  @Override
  public User login(User user) {

    return null;
  }

  @Override
  public User register(User user) {
    Integer result = userMapper.insert(user);
    return null;
  }
}

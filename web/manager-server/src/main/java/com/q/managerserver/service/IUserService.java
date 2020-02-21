package com.q.managerserver.service;

import com.q.entity.User;

/**
 * Create by Administrator on 2020/2/21 0021
 */
public interface IUserService {

  User login(User user);

  User register(User user);
}

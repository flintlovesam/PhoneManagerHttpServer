package com.q.managerserver.controller;

import com.q.entity.ResultEntity;
import com.q.entity.User;
import com.q.managerserver.service.IUserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private IUserService userService;

  /**
   * 用户登录，登录成功拿到cookie才可以进行其他操作
   * @param user
   * @param response
   * @return
   */
  @PostMapping(value = "/login")
  public ResultEntity login(User user,HttpServletResponse response) {
    if (user.getUserName() == null) {
      return ResultEntity.fail("登录失败，请输入账号", null);
    } else if (user.getPassWord() == null) {
      return ResultEntity.fail("登录失败，请输入密码", null);
    }
    User resultUser = userService.login(user);
    resultUser.setPassWord(null);
    Cookie cookie = new Cookie("userName", null);
    response.addCookie(cookie);
    return ResultEntity.success("登录成功", resultUser);
  }

  @PostMapping(value = "/register")
  public ResultEntity register(User user) {
    User result = userService.register(user);
    return ResultEntity.success("注册成功", result);
  }

}

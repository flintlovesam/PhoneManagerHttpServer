package com.q.managerserver.mapper;

import com.q.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@Mapper
public interface IUserMapper {

  User selectOneByUser(@Param("user") User user);

  Integer insert(@Param("user") User user);
}

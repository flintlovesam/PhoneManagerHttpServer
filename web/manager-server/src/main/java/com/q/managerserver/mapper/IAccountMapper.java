package com.q.managerserver.mapper;

import com.q.entity.Account;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Mapper
public interface IAccountMapper {

  Integer insertList(@Param("accounts")List<Account> accountList);

  List<Account> getAccount(@Param("number")Integer number);

  Integer update(@Param("list") List<Integer> list,@Param("date")Date date);
}

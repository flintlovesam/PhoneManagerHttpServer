package com.q.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  private Integer id;

  private String account;
  private String passWord;
  //其他数据，此处不做分割
  private String otherString;

  //是否被使用
  private Integer use;
  //存入时间
  private Date createTime;
  //使用时间
  private Date useTime;
}

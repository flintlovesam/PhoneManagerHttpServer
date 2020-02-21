package com.q.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;

  private String userName;

  private String passWord;

  private long createTime;

}

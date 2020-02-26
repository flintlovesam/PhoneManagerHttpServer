package com.q.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {

  private Integer id;
  private String logString;
  private String devicesId;
  private String createTime;
}

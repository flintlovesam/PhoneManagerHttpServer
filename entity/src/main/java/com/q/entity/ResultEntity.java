package com.q.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Create by Administrator on 2020/2/18 0018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultEntity {

  private static final String SUCCESS = "SUCCESS";
  private static final String FAIL = "FAIL";


  private String code;

  private String status;

  private Object data;

  /**
   * 请求成功响应
   * @param status
   * @param data
   * @return
   */
  public static ResultEntity success(String status, Object data) {

    return new ResultEntity(SUCCESS, status, data);
  }

  /**
   * 请求失败响应
   * @param status
   * @param data
   * @return
   */
  public static ResultEntity fail(String status, Object data) {
    return new ResultEntity(SUCCESS, status, data);
  }


}

package com.q.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertising {

  private String advertising;
  private String filePathImage;
  private String filePathMp3;
}

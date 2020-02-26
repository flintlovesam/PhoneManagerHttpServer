package com.q.managerserver.timer;

import com.q.managerserver.controller.AdvertisingController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@Component
public class Timer {

  /**
   * 定时清理map中的数据 每小时一次
   */
  {
    System.out.println("timer加载");
  }

  @Scheduled(cron = "0 0 0 1/1 * ? ")
  public void cleanMap() {
    System.out.println("定时器启动");
    AdvertisingController.map.clear();
  }

  /**
   * 定时清理日志数据
   */
  @Scheduled(cron = "0 0 0 1/1 * ? ")
  public void cleanLogger() {

  }
}

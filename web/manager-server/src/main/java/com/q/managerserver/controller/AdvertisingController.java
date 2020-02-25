package com.q.managerserver.controller;

import com.q.entity.Advertising;
import com.q.entity.ResultEntity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Administrator on 2020/2/21 0021
 */
@RequestMapping(value = "/Advertising")
@RestController
public class AdvertisingController {

  //维护一个线程安全的map 储存广告词
  public static  Map<String, Object> map = new ConcurrentHashMap<>();

  @RequestMapping(value = "/setAdvertising")
  public ResultEntity setAdvertising(Advertising advertising) {
    map.put(Advertising.class.getName(), advertising);
    return ResultEntity.success("设置成功", null);
  }

  @RequestMapping(value = "/getAdvertising")
  public ResultEntity getAdvertising() {
    Advertising advertising = (Advertising) map.get(Advertising.class.getName());
    if (advertising == null) {
      return ResultEntity.fail("获取失败，未设置广告词", null);
    }
    return ResultEntity.success("获取成功", advertising);
  }

  /**
   * 从map中获取其他的配置数据，比如运行次数
   * @param key
   * @return
   */
  @RequestMapping(value = "/getOtherData")
  public ResultEntity getOtherData(String key) {
    System.out.println(key);
    Object o = map.get(key);
    System.out.println("获取到的数据" + o);
    return ResultEntity.success("获取成功", o.toString());
  }

  /**
   *
   * @param key
   * @param jsonString
   * @return
   */
  @PostMapping(value = "/setOtherData")
  public ResultEntity setOtherData(String key,String jsonString) {
    System.out.println("设置的数据" + jsonString);
    map.put(key, jsonString);
    return ResultEntity.success("设置成功", null);
  }

  /**
   * 获取map中所有的数据
   * @return
   */
  @GetMapping(value = "/getOtherMap")
  public ResultEntity getOtherMap() {
    return ResultEntity.success("", map);
  }
}

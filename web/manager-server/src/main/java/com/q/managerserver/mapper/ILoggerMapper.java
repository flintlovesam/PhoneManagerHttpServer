package com.q.managerserver.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.q.entity.LogEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create by Administrator on 2020/2/25 0025
 */
@Mapper
public interface ILoggerMapper {

  Integer selectCount();

  List<LogEntity> getList(PageInfo<LogEntity> page);
}

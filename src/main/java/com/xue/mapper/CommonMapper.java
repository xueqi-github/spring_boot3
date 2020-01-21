package com.xue.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by xueqi on 2020-01-19 16:55
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

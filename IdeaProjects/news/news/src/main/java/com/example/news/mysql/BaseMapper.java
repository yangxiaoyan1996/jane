package com.example.news.mysql;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 功能描述:
 *
 * @param:
 * @return:
 * @auther: MLC
 * @date: 2018/9/12 18:59
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

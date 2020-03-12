package com.example.authentication.common.baseMapper;/**
 * @author: ait
 * @date: 2020/3/12 22:09
 * @description:
 */

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @project   : authentication
 * @className : MyBaseMapper
 * @author    : ait
 * @time      : 2020年03月12日 22:09
 * @desc      : tk基础mapper
 **/
public interface MyBaseMapper<T> extends Mapper<T>, BaseMapper<T>,MySqlMapper<T> {
}

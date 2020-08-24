package com.example.mapper;

import com.example.entity.Obtain;

import java.util.List;

/**
 * 获奖 Mapper
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface ObtainMapper {
    List<Obtain> findAll();

    void addObtain(Obtain obtain);


}

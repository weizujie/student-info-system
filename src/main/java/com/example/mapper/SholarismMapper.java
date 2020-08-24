package com.example.mapper;

import com.example.entity.Scholarism;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学术 Mapper
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface SholarismMapper {

    Scholarism findById(@Param("id") int id);

    void addSholarism(Scholarism scholarism);

    List<Scholarism> findAll();

}

package com.example.mapper;

import com.example.entity.Scholarism;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface AwardsMapper {

    Scholarism findById(@Param("id") int id);

    void addAwards(Scholarism scholarism);

    List<Scholarism> findAll();

}

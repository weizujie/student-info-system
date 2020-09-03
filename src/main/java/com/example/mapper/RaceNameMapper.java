package com.example.mapper;

import com.example.entity.RaceName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface RaceNameMapper {

    List<RaceName> findAll();

    void addRaceName(RaceName raceName);

    RaceName findById(@Param("id") Integer id);

    void updateRaceName(RaceName raceName);

    void deleteById(@Param("id") Integer id);

}

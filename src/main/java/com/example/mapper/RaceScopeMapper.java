package com.example.mapper;

import com.example.entity.GameLevel;
import com.example.entity.RaceScope;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface RaceScopeMapper {
    List<RaceScope> findAll();

    void addRaceScope(RaceScope raceScope);

    RaceScope findById(Integer id);

    void updateRaceScope(RaceScope raceScope);

    void deleteById(Integer id);
}

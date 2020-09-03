package com.example.service;

import com.example.entity.GameLevel;
import com.example.entity.RaceScope;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface IRaceScopeService {
    List<RaceScope> findAll();

    void addRaceScope(RaceScope raceScope);

    RaceScope findById(Integer id);

    void updateRaceScope(RaceScope raceScope);

    void deleteById(Integer id);
}

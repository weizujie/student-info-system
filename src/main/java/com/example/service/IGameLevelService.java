package com.example.service;

import com.example.entity.GameLevel;

import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface IGameLevelService {
    List<GameLevel> findAll();

    void addGameLevel(GameLevel gameLevel);

    GameLevel findById(Integer id);

    void updateGameLevel(GameLevel gameLevel);

    void deleteById(Integer id);
}

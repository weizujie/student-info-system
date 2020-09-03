package com.example.service.impl;

import com.example.entity.GameLevel;
import com.example.mapper.GameLevelMapper;
import com.example.service.IGameLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Service
public class GameLevelServiceImpl implements IGameLevelService {

    @Autowired
    private GameLevelMapper gameLevelMapper;

    @Override
    public List<GameLevel> findAll() {
        return gameLevelMapper.findAll();
    }

    @Override
    public void addGameLevel(GameLevel gameLevel) {
        gameLevelMapper.addGameLevel(gameLevel);
    }

    @Override
    public GameLevel findById(Integer id) {
        return gameLevelMapper.findById(id);
    }

    @Override
    public void updateGameLevel(GameLevel gameLevel) {
        gameLevelMapper.updateGameLevel(gameLevel);
    }

    @Override
    public void deleteById(Integer id) {
        gameLevelMapper.deleteById(id);
    }
}

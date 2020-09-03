package com.example.mapper;

import com.example.entity.GameLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface GameLevelMapper {

    List<GameLevel> findAll();

    void addGameLevel(GameLevel gameLevel);

    GameLevel findById(@Param("id") Integer id);

    void updateGameLevel(GameLevel gameLevel);

    void deleteById(@Param("id") Integer id);
}

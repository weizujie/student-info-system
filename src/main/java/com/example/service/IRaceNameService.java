package com.example.service;

import com.example.entity.RaceName;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */
public interface IRaceNameService {

    List<RaceName> findAll();

    void addRaceName(RaceName raceName);

    RaceName findById(Integer id);

    void updateRaceName(RaceName raceName);

    void deleteById(Integer id);
}

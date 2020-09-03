package com.example.service.impl;

import com.example.entity.RaceName;
import com.example.mapper.RaceNameMapper;
import com.example.service.IRaceNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Service
public class RaceNameServiceImpl implements IRaceNameService {

    @Autowired
    private RaceNameMapper raceNameMapper;

    @Override
    public List<RaceName> findAll() {
        return raceNameMapper.findAll();
    }

    @Override
    public void addRaceName(RaceName raceName) {
        raceNameMapper.addRaceName(raceName);
    }

    @Override
    public RaceName findById(Integer id) {
        return raceNameMapper.findById(id);
    }

    @Override
    public void updateRaceName(RaceName raceName) {
        raceNameMapper.updateRaceName(raceName);
    }

    @Override
    public void deleteById(Integer id) {
        raceNameMapper.deleteById(id);
    }
}

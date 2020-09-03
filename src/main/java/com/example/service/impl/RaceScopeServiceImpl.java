package com.example.service.impl;

import com.example.entity.GameLevel;
import com.example.entity.RaceScope;
import com.example.mapper.RaceScopeMapper;
import com.example.service.IRaceScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Service
public class RaceScopeServiceImpl implements IRaceScopeService {

    @Autowired
    private RaceScopeMapper raceScopeMapper;

    @Override
    public List<RaceScope> findAll() {
        return raceScopeMapper.findAll();
    }

    @Override
    public void addRaceScope(RaceScope raceScope) {
        raceScopeMapper.addRaceScope(raceScope);
    }

    @Override
    public RaceScope findById(Integer id) {
        return raceScopeMapper.findById(id);
    }

    @Override
    public void updateRaceScope(RaceScope raceScope) {
        raceScopeMapper.updateRaceScope(raceScope);
    }

    @Override
    public void deleteById(Integer id) {
        raceScopeMapper.deleteById(id);
    }
}

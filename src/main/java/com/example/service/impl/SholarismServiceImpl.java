package com.example.service.impl;

import com.example.entity.Scholarism;
import com.example.mapper.AwardsMapper;
import com.example.service.IObtainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Service
public class ObtainServiceImpl implements IObtainService {

    @Autowired
    private AwardsMapper awardsMapper;

    @Override
    public void addScholarism(Scholarism scholarism) {
        awardsMapper.addAwards(scholarism);
    }

    @Override
    public Scholarism findById(int id) {
        return awardsMapper.findById(id);
    }

    @Override
    public List<Scholarism> findAll() {
        return awardsMapper.findAll();
    }
}

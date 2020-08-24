package com.example.service.impl;

import com.example.entity.Scholarism;
import com.example.mapper.SholarismMapper;
import com.example.service.ISholarismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学术统计实现类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Service
public class SholarismServiceImpl implements ISholarismService {

    @Autowired
    private SholarismMapper sholarismMapper;

    @Override
    public void addScholarism(Scholarism scholarism) {
        sholarismMapper.addSholarism(scholarism);
    }

    @Override
    public Scholarism findById(int id) {
        return sholarismMapper.findById(id);
    }

    @Override
    public List<Scholarism> findAll() {
        return sholarismMapper.findAll();
    }
}

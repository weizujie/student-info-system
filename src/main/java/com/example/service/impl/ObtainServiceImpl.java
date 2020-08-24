package com.example.service.impl;

import com.example.entity.Obtain;
import com.example.mapper.ObtainMapper;
import com.example.service.IObtainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获奖统计实现类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Service
public class ObtainServiceImpl implements IObtainService {

    @Autowired
    private ObtainMapper obtainMapper;

    @Override
    public List<Obtain> findAll() {
        return obtainMapper.findAll();
    }

    @Override
    public void addObtain(Obtain obtain) {
        obtainMapper.addObtain(obtain);
    }
}

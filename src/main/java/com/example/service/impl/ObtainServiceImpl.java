package com.example.service.impl;

import com.example.entity.Obtain;
import com.example.mapper.ObtainMapper;
import com.example.service.IObtainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public Obtain findById(Integer id) {
        return obtainMapper.findById(id);
    }

    @Override
    public List<Obtain> search(String studentName) {
        return obtainMapper.search(studentName);
    }

    @Override
    public List<Obtain> getData() {
        return obtainMapper.getData();
    }

    @Override
    public void updateObtain(Obtain obtain) {
        obtainMapper.updateObtain(obtain);
    }

    @Override
    public void deleteById(Integer id) {
        obtainMapper.deleteById(id);
    }

    @Override
    public void saveAll(List<Obtain> obtain) {
        obtainMapper.saveAll(obtain);
    }
}

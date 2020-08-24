package com.example.service;

import com.example.entity.Scholarism;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface IObtainService {
    void addScholarism(Scholarism scholarism);

    Scholarism findById(int id);

    List<Scholarism> findAll();

}

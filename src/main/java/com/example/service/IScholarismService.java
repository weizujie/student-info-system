package com.example.service;

import com.example.entity.Scholarism;

import java.util.List;

/**
 * 学术统计接口
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface IScholarismService {

    void addScholarism(Scholarism scholarism);

    Scholarism findById(int id);

    List<Scholarism> findAll();

    List<Scholarism> search(String applicant);

    List<Scholarism> getData();

    void updateScholarism(Scholarism scholarism);

    void deleteById(Integer id);
}
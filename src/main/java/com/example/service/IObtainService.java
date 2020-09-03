package com.example.service;

import com.example.entity.Obtain;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 获奖统计接口
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface IObtainService {
    List<Obtain> findAll();

    void addObtain(Obtain obtain);

    Obtain findById(Integer id);

    List<Obtain> search(String studentName);

    List<Obtain> getData();

    void updateObtain(Obtain obtain);

    void deleteById(Integer id);

    void saveAll(List<Obtain> obtain);
}

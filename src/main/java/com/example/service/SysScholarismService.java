package com.example.service;

import com.example.model.SysScholarism;
import com.example.vo.R;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */
public interface SysScholarismService {


    R saveScholarism(SysScholarism sysScholarism);

    R selectScholarismList(String name, Pageable pageable);

    R updateScholarism(SysScholarism sysScholarism);

    R deleteScholarism(Integer id);

    R selectScholarismDetail(Integer id);

    List<SysScholarism> findAll();
}

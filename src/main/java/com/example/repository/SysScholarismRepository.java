package com.example.repository;

import com.example.model.SysScholarism;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysScholarismRepository extends JpaRepository<SysScholarism, Integer> {
    Page<SysScholarism> findAll(Specification<SysScholarism> specification, Pageable pageable);
}

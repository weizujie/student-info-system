package com.example.repository;

import com.example.model.SysGameLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysGameLevelRepository extends JpaRepository<SysGameLevel, Integer> {
    Page<SysGameLevel> findAll(Specification<SysGameLevel> sysRoleSpecification, Pageable pageable);

    SysGameLevel findByLevelName(String levelName);
}

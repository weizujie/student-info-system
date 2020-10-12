package com.example.repository;

import com.example.model.SysGameLevel;
import com.example.model.SysObtain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysObtainRepository extends JpaRepository<SysObtain, Integer> {

    Page<SysObtain> findAll(Specification<SysObtain> sysRoleSpecification, Pageable pageable);


}

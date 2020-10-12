package com.example.repository;

import com.example.model.SysObtain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysObtainRepository extends JpaRepository<SysObtain, Integer>, JpaSpecificationExecutor<SysObtain> {

    Page<SysObtain> findAll(Specification<SysObtain> sysRoleSpecification, Pageable pageable);

}

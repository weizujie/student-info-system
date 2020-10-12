package com.example.repository;

import com.example.model.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

    Page<SysRole> findAll(Specification<SysRole> sysRoleSpecification, Pageable pageable);
}

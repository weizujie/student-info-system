package com.example.repository;

import com.example.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    SysUser findByAccount(String account);

    Page<SysUser> findAll(Specification<SysUser> sysRoleSpecification, Pageable pageable);
}

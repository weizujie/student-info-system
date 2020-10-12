package com.example.repository;

import com.example.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Integer> {

    List<SysUserRole> findByUserId(Integer id);

    void deleteByUserId(Integer id);
}

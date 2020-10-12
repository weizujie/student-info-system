package com.example.repository;

import com.example.model.SysRoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleResourceRepository extends JpaRepository<SysRoleResource,Integer> {

    List<SysRoleResource> findByRoleId(Integer roleId);

    List<SysRoleResource> findByRoleId(List<Integer> roleIds);

    void deleteByRoleId(Integer id);
}

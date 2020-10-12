package com.example.service;

import com.example.from.SysRoleFrom;
import com.example.vo.R;
import org.springframework.data.domain.Pageable;

public interface SysRoleService {

    R saveRole(SysRoleFrom sysRoleFrom);

    R selectRoleList(String name,Pageable pageable);

    R selectRoleDetail(Integer id);

    R updateRole(SysRoleFrom sysRoleFrom);

    R deleteRole(Integer id);
}

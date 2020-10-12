package com.example.service;

import com.example.from.SysUserFrom;
import com.example.model.SysUser;
import com.example.vo.R;
import org.springframework.data.domain.Pageable;

public interface SysUserService {

    SysUser findByAccount(String account);

    R saveUser(SysUserFrom sysUserFrom);

    R selectUserList(String name, Pageable pageable);

    R selectUserDetail(Integer id);

    R updateUser(SysUserFrom sysUserFrom);

    R deleteUser(Integer id);
}

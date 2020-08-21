package com.example.service;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
public interface IUserService {

    List<User> findAll();

    User findByUsername(String username);

    User login(User user);

    void register(User user);


}

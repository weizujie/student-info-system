package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
public interface UserMapper {

    List<User> findAll();

    User findByUsername(@Param("username") String username);

    User login(User user);

    void register(User user);


}

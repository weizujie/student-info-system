package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User login(User user) {
        User dbUser = userMapper.login(user);
        if (dbUser != null) {
            return dbUser;
        }
        throw new RuntimeException("用户名或密码错误，请重新输入");
    }

    @Override
    public void register(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("该用户名已存在，请重新输入");
        }
        userMapper.register(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }


}

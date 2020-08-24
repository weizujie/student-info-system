package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.cs.ext.MacArabic;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理实现类
 *
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
@Service
public class UserServiceImpl implements IUserService {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

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
    public void addUser(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("该用户名已存在，请重新输入");
        }
        userMapper.addUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void updateAvatar(Integer id, String avatar) {
        userMapper.updateAvatar(id, avatar);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }


}

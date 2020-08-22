package com.example.service;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
public interface IUserService {

    List<User> findAll();

    User findByUsername(String username);

    User login(User user);

    void addUser(User user);

    User findById(Integer id);

    void updateAvatar(Integer id, String avatar);
}

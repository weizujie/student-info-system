package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 用户 Mapper
 *
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */
public interface UserMapper {

    List<User> findAll();

    User findByUsername(@Param("username") String username);

    User findById(@Param("id") Integer id);

    User login(User user);

    void addUser(User user);

    void deleteById(@Param("id") Integer id);

    void updateUser(User user);

    void updateAvatar(@Param("id") Integer id, @Param("avatar") String avatar);


}

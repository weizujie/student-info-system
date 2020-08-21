package com.example.entity;

import lombok.Data;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */

@Data
public class User {

    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 手机号
    private String mobile;
    // 头像
    private String avatar;

}

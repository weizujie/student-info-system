package com.example.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.User;
import com.example.service.IUserService;
import com.example.utils.JWTUtils;
import com.example.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     */
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, String> payload = new HashMap<>(); // 用于存放payload
        Map<String, Object> result = new HashMap<>();
        try {
            User dbUser = userService.login(user);
            payload.put("id", String.valueOf(dbUser.getId()));
            payload.put("username", dbUser.getUsername());
            // 生成JWT令牌
            String token = JWTUtils.getToken(payload);
            result.put("id", String.valueOf(dbUser.getId()));
            result.put("username", dbUser.getUsername());
            result.put("email", dbUser.getEmail());
            result.put("mobile", dbUser.getMobile());
            result.put("avatar", dbUser.getAvatar());
            result.put("token", token);
            result.put("status", 200);
            result.put("msg", "登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", "false");
            result.put("msg", e.getMessage());

        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param user 用户实体类
     * @return
     */
    @PostMapping(value = "/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.register(user);
            result.put("status", 201);
            result.put("msg", "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", "false");
            result.put("msg", e.getMessage());
        }
        return result;
    }

    /**
     * 展示用户数据
     *
     * @return
     */
    @GetMapping(value = "/users")
    public Map<String, Object> users(HttpServletRequest request,
                                     @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> map = new HashMap<>();

        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users, 5);
        map.put("pageInfo", pageInfo);
        String token = request.getHeader("token");
        JWTUtils.verify(token);
        map.put("status", 200);
        map.put("msg", "请求成功");
        return map;
    }
}

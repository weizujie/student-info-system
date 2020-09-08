package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import com.example.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户登录控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/22
 * @Github: https://github.com/weizujie
 */

@RestController
@Slf4j
@RequestMapping(value = "api/v1")
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     */
    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User user, HttpSession session, HttpServletRequest request) {
        Map<String, String> payload = new LinkedHashMap<>(); // 用于存放payload
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        try {
            User dbUser = userService.login(user);
            // 将当前登录的用户id存入session中，以便后续更改头像使用
            session.setAttribute("currentUserId", dbUser.getId());
            Integer currentUserId = Integer.valueOf(request.getSession().getAttribute("currentUserId").toString());
            log.info("登录用户的id：" + currentUserId);
            payload.put("id", String.valueOf(dbUser.getId()));
            payload.put("username", dbUser.getUsername());
            // 生成JWT令牌
            String token = JWTUtil.getToken(payload);
            // 构造json数据
            data.put("id", String.valueOf(dbUser.getId()));
            data.put("username", dbUser.getUsername());
            data.put("email", dbUser.getEmail());
            data.put("mobile", dbUser.getMobile());
            data.put("token", token);
            map.put("code", 200);
            map.put("msg", "登录成功");
            result.put("data", data);
            result.put("meta", map);

        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "500");
            result.put("msg", e.getMessage());
        }
        return result;
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public Map<String, Object> login(HttpSession session) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        session.invalidate();
        meta.put("code", 200);
        meta.put("msg", "退出成功");
        result.put("meta", meta);
        return result;
    }

}

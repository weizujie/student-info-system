package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/9/8
 * @Github: https://github.com/weizujie
 */
@RestController
@RequestMapping(value = "api/v1")
public class ErrorController {

    @GetMapping("/unauthorized")
    public Map<String, Object> unauthorized() {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();

        meta.put("code", 401);
        meta.put("msg", "禁止访问未授权页面");
        result.put("meta", meta);
        return result;
    }

}

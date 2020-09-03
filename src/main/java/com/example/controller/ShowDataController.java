package com.example.controller;

import com.example.entity.Obtain;
import com.example.entity.Scholarism;
import com.example.service.IObtainService;
import com.example.service.IScholarismService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: weizujie
 * @Date: 2020/8/27
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class ShowDataController {

    @Autowired
    private IScholarismService sholarismService;

    @Autowired
    private IObtainService obtainService;

    @GetMapping("/allData")
    public Map<String, Object> allData() {
        Map<String, Object> obtain = new LinkedHashMap<>();
        Map<String, Object> scholarism = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();

        List<Obtain> obtains = obtainService.getData();
        List<Scholarism> scholarisms = sholarismService.getData();
        obtain.put("data", obtains);
        scholarism.put("data", scholarisms);
        result.put("obtain", obtain);
        result.put("scholarism", scholarism);
        return result;
    }

    @GetMapping("/academicAll")
    public Map<String, Object> academicAll() {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();

        List<Obtain> obtains = obtainService.findAll();
        List<Scholarism> scholarisms = sholarismService.findAll();
        meta.put("code", 200);
        meta.put("msg", "获取成功");
        result.put("obtain", obtains);
        result.put("scholarism", scholarisms);
        result.put("meta", meta);
        return result;
    }
}

package com.example.controller;

import com.example.entity.Scholarism;
import com.example.service.ISholarismService;
import com.example.utils.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 学术情况统计控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class ScholarismController {

    @Autowired
    private ISholarismService sholarismService;

    /**
     * 展示所有scholarism
     *
     * @return
     */
    @GetMapping("/scholarism")
    public Map<String, Object> Scholarism(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<Scholarism> scholarism = sholarismService.findAll();
        PageInfo<Scholarism> dbScholarism = new PageInfo<>(scholarism);
        // 验证 token
        String token = request.getHeader("token");
        JWTUtil.verify(token);
        log.info("请求scholarism的token->" + token);

        // 构造 json 数据
        data.put("scholarism", dbScholarism.getList());
        meta.put("code", 200);
        meta.put("msg", "获取数据成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

    /**
     * 添加scholarism信息
     *
     * @param scholarism
     * @return
     */
    @PostMapping("/scholarism")
    public Map<String, Object> addScholarism(@RequestBody Scholarism scholarism) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            sholarismService.addScholarism(scholarism);
            // 构造 json 数据
            result.put("code", 201);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("msg", "添加失败");
        }
        return result;
    }

}

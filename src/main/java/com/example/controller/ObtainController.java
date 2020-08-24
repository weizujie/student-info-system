package com.example.controller;

import com.example.entity.CompetitionStatistics;
import com.example.service.ICompetitionStatisticsService;
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
 * 获奖统计控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class CompetitionStatisticsController {

    @Autowired
    private ICompetitionStatisticsService competitionStatisticsService;


    @GetMapping("/competitionStatistics")
    public Map<String, Object> addCompetitionStatistics(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<CompetitionStatistics> competitionStatistics = competitionStatisticsService.findAll();
        PageInfo<CompetitionStatistics> dbCompetitionStatistics = new PageInfo<>(competitionStatistics);
        // 验证 token
        String token = request.getHeader("token");
        JWTUtil.verify(token);
        log.info("请求competitionStatistics的token->" + token);

        // 构造 json 数据
        data.put("competitionStatistics", dbCompetitionStatistics.getList());
        meta.put("code", 200);
        meta.put("msg", "获取数据成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

}

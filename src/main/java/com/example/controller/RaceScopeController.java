package com.example.controller;

import com.example.entity.GameLevel;
import com.example.entity.RaceScope;
import com.example.service.IGameLevelService;
import com.example.service.IRaceScopeService;
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
 * 竞赛范围控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class RaceScopeController {

    @Autowired
    private IRaceScopeService raceScopeService;

    /**
     * 获取所有赛事范围
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/raceScope")
    public Map<String, Object> getRaceScope(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<RaceScope> raceScopes = raceScopeService.findAll();
        PageInfo<RaceScope> dbRaceScope = new PageInfo<>(raceScopes);
        // 构造 json 数据
        data.put("totalpage", dbRaceScope.getTotal());
        data.put("pagenum", dbRaceScope.getPageNum());
        data.put("raceScopeInfo", dbRaceScope.getList());
        meta.put("code", 200);
        meta.put("msg", "获取成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

    /**
     * 添加赛事范围
     *
     * @param raceScope
     * @return
     */
    @PostMapping("/raceScope")
    public Map<String, Object> addRaceScope(@RequestBody RaceScope raceScope) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            raceScopeService.addRaceScope(raceScope);
            // 构造 json 数据
            result.put("code", 201);
            result.put("msg", "竞赛等级创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("msg", "创建失败");
        }
        return result;
    }

    /**
     * 根据id查询赛事范围
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/raceScope/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            RaceScope dbRaceScope = raceScopeService.findById(id);
            meta.put("code", 200);
            meta.put("msg", "查询成功");
            result.put("data", dbRaceScope);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 200);
            result.put("msg", "查询成功");
        }
        return result;
    }

    /**
     * 根据id修改赛事范围
     *
     * @param id
     * @param raceScope
     * @return
     */
    @PutMapping(value = "/raceScope/{id}")
    public Map<String, Object> updateRaceScope(@PathVariable("id") Integer id, @RequestBody RaceScope raceScope) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            raceScope.setId(id);
            raceScopeService.updateRaceScope(raceScope);
            meta.put("code", 200);
            meta.put("msg", "更新成功");
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "更新失败");
        }
        return result;
    }

    /**
     * 根据id删除赛事范围
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/raceScope/{id}")
    public Map<String, Object> deleteRaceScope(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            raceScopeService.deleteById(id);
            result.put("code", 204);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "删除失败");
        }
        return result;
    }


}

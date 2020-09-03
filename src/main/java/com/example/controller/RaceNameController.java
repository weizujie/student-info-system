package com.example.controller;

import com.example.entity.RaceName;
import com.example.service.IRaceNameService;
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
 * 竞赛名称控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class RaceNameController {

    @Autowired
    private IRaceNameService raceNameService;

    /**
     * 获取所有赛事名称
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/raceName")
    public Map<String, Object> getRaceName(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<RaceName> raceNames = raceNameService.findAll();
        PageInfo<RaceName> dbRaceName = new PageInfo<>(raceNames);
        // 构造 json 数据
        data.put("totalpage", dbRaceName.getTotal());
        data.put("pagenum", dbRaceName.getPageNum());
        data.put("raceNameInfo", dbRaceName.getList());
        meta.put("code", 200);
        meta.put("msg", "获取成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

    /**
     * 添加赛事名称
     *
     * @param raceName
     * @return
     */
    @PostMapping("/raceName")
    public Map<String, Object> addRaceName(@RequestBody RaceName raceName) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            raceNameService.addRaceName(raceName);
            // 构造 json 数据
            result.put("code", 201);
            result.put("msg", "竞赛名称创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("msg", "创建失败");
        }
        return result;
    }

    /**
     * 根据id查询赛事名称
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/raceName/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            RaceName dbRaceName = raceNameService.findById(id);
            meta.put("code", 200);
            meta.put("msg", "查询成功");
            result.put("data", dbRaceName);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 200);
            result.put("msg", "查询成功");
        }
        return result;
    }

    /**
     * 根据id修改赛事名称
     *
     * @param id
     * @param raceName
     * @return
     */
    @PutMapping(value = "/raceName/{id}")
    public Map<String, Object> updateRaceName(@PathVariable("id") Integer id, @RequestBody RaceName raceName) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            raceName.setId(id);
            raceNameService.updateRaceName(raceName);
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
     * 根据id删除赛事名称
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/raceName/{id}")
    public Map<String, Object> deleteRaceName(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            raceNameService.deleteById(id);
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

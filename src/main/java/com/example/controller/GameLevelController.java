package com.example.controller;

import com.example.entity.GameLevel;
import com.example.entity.Scholarism;
import com.example.service.IGameLevelService;
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
 * 竞赛等级控制器
 *
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1")
public class GameLevelController {

    @Autowired
    private IGameLevelService gameLevelService;

    /**
     * 获取所有赛事级别
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/gameLevel")
    public Map<String, Object> getGameLevel(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<GameLevel> gameLevels = gameLevelService.findAll();
        PageInfo<GameLevel> dbGameLevel = new PageInfo<>(gameLevels);
        // 构造 json 数据
        data.put("totalpage", dbGameLevel.getTotal());
        data.put("pagenum", dbGameLevel.getPageNum());
        data.put("levelNameInfo", dbGameLevel.getList());
        meta.put("code", 200);
        meta.put("msg", "获取成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

    /**
     * 添加赛事级别
     *
     * @param gameLevel
     * @return
     */
    @PostMapping("/gameLevel")
    public Map<String, Object> addGameLevel(@RequestBody GameLevel gameLevel) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            gameLevelService.addGameLevel(gameLevel);
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
     * 根据id查询赛事级别
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/gameLevel/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            GameLevel dbGameLevel = gameLevelService.findById(id);
            meta.put("code", 200);
            meta.put("msg", "查询成功");
            result.put("data", dbGameLevel);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 200);
            result.put("msg", "查询成功");
        }
        return result;
    }

    /**
     * 根据id修改赛事级别
     *
     * @param id
     * @param gameLevel
     * @return
     */
    @PutMapping(value = "/gameLevel/{id}")
    public Map<String, Object> updateGameLevel(@PathVariable("id") Integer id, @RequestBody GameLevel gameLevel) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            gameLevel.setId(id);
            gameLevelService.updateGameLevel(gameLevel);
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
     * 根据id删除赛事级别
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/gameLevel/{id}")
    public Map<String, Object> deleteGameLevel(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            gameLevelService.deleteById(id);
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

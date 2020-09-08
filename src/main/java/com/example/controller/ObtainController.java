package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.example.entity.Obtain;
import com.example.entity.Scholarism;
import com.example.entity.User;
import com.example.listener.ObtainListener;
import com.example.service.IObtainService;
import com.example.utils.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
public class ObtainController {

    @Autowired
    private IObtainService obtainService;

    /**
     * 获取所有获奖情况
     *
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/obtain")
    public Map<String, Object> Obtain(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> result = new LinkedHashMap<>();
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<Obtain> obtains = obtainService.findAll();
        PageInfo<Obtain> dbObtain = new PageInfo<>(obtains);
        // 验证 token
        String token = request.getHeader("token");
        JWTUtil.verify(token);
        // 构造 json 数据
        data.put("obtain", dbObtain.getList());
        data.put("total", dbObtain.getTotal());
        data.put("pagenum", dbObtain.getPageNum());
        meta.put("code", 200);
        meta.put("msg", "获取数据成功");
        result.put("data", data);
        result.put("meta", meta);
        return result;
    }

    /**
     * 根据id查询获奖信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/obtain/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            Obtain dbObtain = obtainService.findById(id);
            data.put("obtain", dbObtain);
            meta.put("code", 200);
            meta.put("msg", "查询成功");
            result.put("data", data);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 200);
            result.put("msg", "查询成功");
        }
        return result;
    }

    /**
     * 删除指定id获奖信息
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/obtain/{id}")
    public Map<String, Object> deleteObtain(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            obtainService.deleteById(id);
            result.put("code", 204);
            result.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "删除失败");
        }
        return result;
    }

    /**
     * 添加获奖信息
     *
     * @param obtain
     * @return
     */
    @PostMapping("/obtain")
    public Map<String, Object> addObtain(@RequestBody Obtain obtain) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            obtainService.addObtain(obtain);
            // id在插入mysql的时候显示的是0，所以不能用此方法来获取获奖信息
            // Obtain dbObtain =  obtainService.findById(obtain.getId());
            // 构造 json 数据
            // result.put("data", dbObtain);
            result.put("code", 201);
            result.put("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("msg", "添加失败");
        }
        return result;
    }

    /**
     * 搜索框查询指定获奖信息
     *
     * @param query
     * @return
     */
    @PostMapping("/obtain/search")
    public Map<String, Object> search(String query) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        try {
            List<Obtain> dbObtain = obtainService.search(query);
            // 构造 json 数据
            data.put("obtain", dbObtain);
            meta.put("code", 200);
            meta.put("msg", "搜索成功");
            result.put("data", data);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 0);
            result.put("msg", "搜索失败");
        }
        return result;
    }

    /**
     * 更新指定id获奖信息
     *
     * @param obtain
     * @return
     */
    @PutMapping(value = "/obtain/{id}")
    public Map<String, Object> updateScholarism(@PathVariable("id") Integer id, @RequestBody Obtain obtain) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            obtain.setId(id);
            obtainService.updateObtain(obtain);
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
     * 上传 Excel 文件
     *
     * @param excel
     * @return
     */
    @PostMapping(value = "/obtain/importExcel")
    public Map<String, Object> importExcel(MultipartFile excel) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();

        try {
            // EasyExcel.read(excel.getInputStream(), Obtain.class, new ObtainListener(obtainService)).sheet().doRead();
            List<Object> obtain = EasyExcel.read(excel.getInputStream(), Obtain.class, new ObtainListener((obtainService))).sheet().doReadSync();
            data.put("obtain", obtain);
            meta.put("code", 200);
            meta.put("msg", "上传成功");
            result.put("data", data);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "上传失败");
        }
        return result;
    }

    /**
     * 下载 Excel 文件
     *
     * @return
     */
    @GetMapping(value = "/obtain/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Obtain> obtains = obtainService.findAll();
        String fileName = "ObtainExcel";
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), Obtain.class).sheet("Obtain").doWrite(obtains);
            log.info("下载ObtainExcel.xlsx文件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}

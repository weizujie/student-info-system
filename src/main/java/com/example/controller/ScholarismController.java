package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.example.entity.Obtain;
import com.example.entity.Scholarism;
import com.example.listener.ObtainListener;
import com.example.listener.ScholarismListener;
import com.example.service.IScholarismService;
import com.example.utils.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private IScholarismService sholarismService;

    /**
     * 展示所有scholarism
     *
     * @return
     */
    @GetMapping("/scholarism")
    public Map<String, Object> Scholarism(HttpServletRequest request,
                                          @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
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
        // 构造 json 数据
        data.put("scholarism", dbScholarism.getList());
        data.put("total", dbScholarism.getTotal());
        data.put("pagenum", dbScholarism.getPageNum());
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
    @GetMapping(value = "/scholarism/{id}")
    public Map<String, Object> findById(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            Scholarism dbScholarism = sholarismService.findById(id);
            data.put("scholarism", dbScholarism);
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
     * 删除指定id学术信息
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/scholarism/{id}")
    public Map<String, Object> deleteScholarism(@PathVariable("id") Integer id) {
        Map<String, Object> result = new LinkedHashMap<>();
        try {
            sholarismService.deleteById(id);
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

    /**
     * 搜索框查询指定获奖信息
     *
     * @param query
     * @return
     */
    @GetMapping("/scholarism/search/{query}")
    public Map<String, Object> search(@PathVariable("query") String query) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        try {
            List<Scholarism> dbScholarism = sholarismService.search(query);
            // 构造 json 数据
            data.put("scholarism", dbScholarism);
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
     * 更新指定id学术信息
     *
     * @param scholarism
     * @return
     */
    @PutMapping(value = "/scholarism/{id}")
    public Map<String, Object> updateScholarism(@PathVariable("id") Integer id, @RequestBody Scholarism scholarism) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {
            scholarism.setId(id);
            sholarismService.updateScholarism(scholarism);
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
     * @param excelFile
     * @return
     */
    @PostMapping(value = "/scholarism/importExcel")
    public Map<String, Object> importExcel(@RequestParam("excel") MultipartFile excelFile) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        try {
            List<Object> scholarism = EasyExcel.read(excelFile.getInputStream(), Scholarism.class, new ScholarismListener(sholarismService)).sheet().doReadSync();
            data.put("scholarism", scholarism);
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
    @GetMapping(value = "/scholarism/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Scholarism> scholarisms = sholarismService.findAll();
        String fileName = "ScholarismExcel";
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), Scholarism.class).sheet("Scholarism").doWrite(scholarisms);
            log.info("下载ScholarismExcel.xlsx文件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}

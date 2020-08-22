package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import com.example.utils.JWTUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.cs.US_ASCII;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: weizujie
 * @Date: 2020/8/20
 * @Github: https://github.com/weizujie
 */

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "api/v1")
public class UserController {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Autowired
    private IUserService userService;

    /**
     * 展示用户数据
     *
     * @return
     */
    @GetMapping(value = "/users")
    public Map<String, Object> users(HttpServletRequest request, @RequestParam(name = "pagenum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        // 验证 token
        String token = request.getHeader("token");
        JWTUtil.verify(token);
        // 构造 json 数据
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> map2 = new LinkedHashMap<>();
        Map<String, Object> data = new LinkedHashMap<>();
        map.put("totalpage", pageInfo.getTotal());
        map.put("pagenum", pageInfo.getPageNum());
        map.put("users", users);
        data.put("data", map);
        map2.put("msg", "获取成功");
        map2.put("status", 200);
        map.put("meta", map2);
        return data;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> meta = new LinkedHashMap<>();
        try {

            // 设置默认头像
            user.setAvatar("https://cdn.jsdelivr.net/gh/weizujie/weizujie.github.io@latest/images/avatar.jpg");
            userService.addUser(user);
            User dbUser = userService.findByUsername(user.getUsername());

            // 构造 json 数据
            map.put("id", String.valueOf(dbUser.getId()));
            map.put("username", dbUser.getUsername());
            map.put("email", dbUser.getEmail());
            map.put("mobile", dbUser.getMobile());
            map.put("avatar", dbUser.getAvatar());
            meta.put("status", 201);
            meta.put("msg", "用户创建成功");
            result.put("data", map);
            result.put("meta", meta);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "0");
            result.put("msg", e.getMessage());
        }
        return result;
    }

    /**
     * 用户头像更新
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/updateAvatar")
    public Map<String, Object> updateAvatar(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new LinkedHashMap<>();
        if (file.isEmpty()) {
            map.put("code", 400);
            map.put("msg", "请选择上传文件");
            return map;
        }
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        String originalFilename = file.getOriginalFilename();
        String fileName = System.currentTimeMillis() + "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String filePath = uploadFolder;
        File dest = new File(filePath + fileName);
        if (dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            // 获取当前登录用户
            Integer currentUserId = Integer.valueOf(request.getSession().getAttribute("currentUserId").toString());
            System.out.println("=================:" + currentUserId);
            // 根据id查询用户
            User result = userService.findById(currentUserId);
            // 更新头像
            String avatar = basePath + "/static/images/" + fileName;
            userService.updateAvatar(result.getId(), avatar);
            map.put("code", 200);
            map.put("msg", "上传成功");
            map.put("path", basePath + "/static/images/" + fileName); // 上传的头像地址
        } catch (Exception e) {
            e.printStackTrace();
            map.put("500", "上传失败");
            return map;
        }
        return map;
    }

}

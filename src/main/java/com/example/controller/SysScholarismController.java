package com.example.controller;

import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.model.SysScholarism;
import com.example.service.SysScholarismService;
import com.example.utils.Assert;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 学术统计
 *
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/sys")
@Slf4j
public class SysScholarismController {

    @Autowired
    private SysScholarismService sysScholarismService;


    /**
     * 新增学术统计
     *
     * @param sysScholarism
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:scholarism:insert")
    @PostMapping("/saveScholarism")
    public R saveScholarism(@Valid @RequestBody SysScholarism sysScholarism,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增学术】参数不正确:sysScholarism={}" + sysScholarism);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysScholarismService.saveScholarism(sysScholarism);
    }


    /**
     * 查询学术统计列表
     *
     * @param page
     * @param size
     * @param name
     * @return
     */
    @RequiresPermissions("sys:scholarism:list")
    @GetMapping("/selectScholarismList")
    public R selectScholarismList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "name", defaultValue = "") String name) {

        PageRequest pageRequest = new PageRequest(page, size);
        return sysScholarismService.selectScholarismList(name, pageRequest);
    }

    /**
     * 查询学术统计详情
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:scholarism:detail")
    @GetMapping("/selectScholarismDetail")
    public R selectScholarismDetail(@RequestParam(value = "id", required = false) Integer id) {
        Assert.isNull(id, "id不能为空");
        return sysScholarismService.selectScholarismDetail(id);
    }


    /**
     * 更新学术统计
     *
     * @param sysScholarism
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:scholarism:update")
    @PutMapping("/updateScholarism")
    public R updateScholarism(@Valid @RequestBody SysScholarism sysScholarism,
                              BindingResult bindingResult) {

        Assert.isNull(sysScholarism.getId(), "id不能为空");

        if (bindingResult.hasErrors()) {
            log.error("【更新学术】参数不正确:sysScholarism={}" + sysScholarism);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysScholarismService.updateScholarism(sysScholarism);
    }


    /**
     * 删除学术统计
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:scholarism:delete")
    @DeleteMapping("/deleteScholarism/{id}")
    public R deleteScholarism(@PathVariable Integer id) {
        return sysScholarismService.deleteScholarism(id);
    }


}

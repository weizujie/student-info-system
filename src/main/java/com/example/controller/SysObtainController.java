package com.example.controller;

import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.model.SysObtain;
import com.example.service.SysObtainService;
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
 * 获奖统计
 *
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/sys")
@Slf4j
public class SysObtainController {

    @Autowired
    private SysObtainService sysObtainService;

    /**
     * 新增获奖
     *
     * @param sysObtain
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:obtain:insert")
    @PostMapping("/saveObtain")
    public R saveObtain(@Valid @RequestBody SysObtain sysObtain,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增获奖】参数不正确:sysObtain={}" + sysObtain);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysObtainService.saveObtain(sysObtain);
    }

    /**
     * 查询获奖列表
     *
     * @param page
     * @param size
     * @param name
     * @return
     */
    @RequiresPermissions("sys:obtain:list")
    @GetMapping("/selectObtainList")
    public R selectObtainList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "name", defaultValue = "") String name) {

        PageRequest pageRequest = new PageRequest(page, size);
        return sysObtainService.selectObtainList(name, pageRequest);
    }

    /**
     * 查询获奖详情
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:obtain:detail")
    @GetMapping("/selectObtainDetail")
    public R selectObtainDetail(@RequestParam(value = "id", required = false) Integer id) {
        Assert.isNull(id, "id不能为空");
        return sysObtainService.selectObtainDetail(id);
    }

    /**
     * 更新获奖
     *
     * @param sysObtain
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:obtain:update")
    @PutMapping("/updateObtain")
    public R updateObtain(@Valid @RequestBody SysObtain sysObtain,
                          BindingResult bindingResult) {

        Assert.isNull(sysObtain.getId(), "id不能为空");

        if (bindingResult.hasErrors()) {
            log.error("【更新获奖】参数不正确:sysObtain={}" + sysObtain);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysObtainService.updateObtain(sysObtain);
    }


    /**
     * 删除获奖
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:obtain:delete")
    @DeleteMapping("/deleteObtain/{id}")
    public R deleteObtain(@PathVariable Integer id) {
        return sysObtainService.deleteObtain(id);
    }


}

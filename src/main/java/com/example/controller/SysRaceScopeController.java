package com.example.controller;

import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.model.SysRaceScope;
import com.example.service.SysRaceScopeService;
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
 * 赛事范围
 *
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/sys")
@Slf4j
public class SysRaceScopeController {

    @Autowired
    private SysRaceScopeService sysRaceScopeService;


    /**
     * 新增赛事范围
     *
     * @param sysRaceScope
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:racescope:insert")
    @PostMapping("/saveRaceScope")
    public R saveRaceScope(@Valid @RequestBody SysRaceScope sysRaceScope,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增赛事】参数不正确:sysRaceScope={}" + sysRaceScope);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysRaceScopeService.saveRaceScope(sysRaceScope);
    }


    /**
     * 查询赛事范围列表
     *
     * @param page
     * @param size
     * @param Scope
     * @return
     */
    @RequiresPermissions("sys:racescope:list")
    @GetMapping("/selectRaceScopeList")
    public R selectRaceScopeList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "Scope", defaultValue = "") String Scope) {

        PageRequest pageRequest = new PageRequest(page, size);
        return sysRaceScopeService.selectRaceScopeList(Scope, pageRequest);
    }

    /**
     * 查询赛事范围详情
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:racescope:detail")
    @GetMapping("/selectRaceScopeDetail")
    public R selectRaceScopeDetail(@RequestParam(value = "id", required = false) Integer id) {
        Assert.isNull(id, "id不能为空");
        return sysRaceScopeService.selectRaceScopeDetail(id);
    }


    /**
     * 更新赛事范围
     *
     * @param sysRaceScope
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:racescope:update")
    @PutMapping("/updateRaceScope")
    public R updateRaceScope(@Valid @RequestBody SysRaceScope sysRaceScope,
                             BindingResult bindingResult) {

        Assert.isNull(sysRaceScope.getId(), "id不能为空");

        if (bindingResult.hasErrors()) {
            log.error("【更新赛事范围】参数不正确:sysRaceScope={}" + sysRaceScope);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysRaceScopeService.updateRaceScope(sysRaceScope);
    }


    /**
     * 删除赛事范围
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:racescope:delete")
    @DeleteMapping("/deleteRaceScope/{id}")
    public R deleteRaceScope(@PathVariable Integer id) {
        return sysRaceScopeService.deleteRaceScope(id);
    }

}

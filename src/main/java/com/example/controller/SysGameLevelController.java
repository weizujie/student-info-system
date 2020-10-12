package com.example.controller;

import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.model.SysGameLevel;
import com.example.service.SysGameLevelService;
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
 * 赛事等级
 *
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/sys")
@Slf4j
public class SysGameLevelController {

    @Autowired
    private SysGameLevelService sysGameLevelService;


    /**
     * 新增赛事等级
     *
     * @param sysGameLevel
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:gamelevel:insert")
    @PostMapping("/saveGameLevel")
    public R saveGameLevel(@Valid @RequestBody SysGameLevel sysGameLevel,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增赛事等级】参数不正确:sysGameLevel={}" + sysGameLevel);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysGameLevelService.saveGameLevel(sysGameLevel);
    }


    /**
     * 查询赛事等级列表
     *
     * @param page
     * @param size
     * @return
     */
    @RequiresPermissions("sys:gamelevel:list")
    @GetMapping("/selectGameLevelList")
    public R selectGameLevelList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "name", defaultValue = "") String name) {

        PageRequest pageRequest = new PageRequest(page, size);
        return sysGameLevelService.selectGameLevelList(name, pageRequest);
    }

    @RequiresPermissions("sys:gamelevel:detail")
    @GetMapping("/selectGameLevelDetail")
    public R selectGameLevelDetail(@RequestParam(value = "id", required = false) Integer id) {
        Assert.isNull(id, "id不能为空");
        return sysGameLevelService.selectGameLevelDetail(id);
    }


    /**
     * 更新赛事等级
     *
     * @param sysGameLevel
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:gamelevel:update")
    @PutMapping("/updateGameLevel")
    public R updateGameLevel(@Valid @RequestBody SysGameLevel sysGameLevel,
                             BindingResult bindingResult) {

        Assert.isNull(sysGameLevel.getId(), "id不能为空");

        if (bindingResult.hasErrors()) {
            log.error("【更新赛事等级】参数不正确:sysGameLevelFrom={}" + sysGameLevel);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysGameLevelService.updateGameLevel(sysGameLevel);
    }


    /**
     * 删除赛事等级
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:gamelevel:delete")
    @DeleteMapping("/deleteGameLevel/{id}")
    public R deleteGameLevel(@PathVariable Integer id) {
        return sysGameLevelService.deleteGameLevel(id);
    }


}

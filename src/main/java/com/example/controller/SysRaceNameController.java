package com.example.controller;

import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.model.SysRaceName;
import com.example.service.SysRaceNameService;
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
 * 赛事名称
 *
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */

@RestController
@RequestMapping("/sys")
@Slf4j
public class SysRaceNameController {

    @Autowired
    private SysRaceNameService sysRaceNameService;


    /**
     * 新增赛事名称
     *
     * @param sysRaceName
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:racename:insert")
    @PostMapping("/saveRaceName")
    public R saveRaceName(@Valid @RequestBody SysRaceName sysRaceName,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【新增赛事名称】参数不正确:sysRaceName={}" + sysRaceName);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysRaceNameService.saveRaceName(sysRaceName);
    }


    /**
     * 查询赛事名称列表
     *
     * @param page
     * @param size
     * @param name
     * @return
     */
    @RequiresPermissions("sys:racename:list")
    @GetMapping("/selectRaceNameList")
    public R selectRaceNameList(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "name", defaultValue = "") String name) {

        PageRequest pageRequest = new PageRequest(page, size);
        return sysRaceNameService.selectRaceNameList(name, pageRequest);
    }

    /**
     * 查询赛事名称详情
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:racename:detail")
    @GetMapping("/selectRaceNameDetail")
    public R selectRaceNameDetail(@RequestParam(value = "id", required = false) Integer id) {
        Assert.isNull(id, "id不能为空");
        return sysRaceNameService.selectRaceNameDetail(id);
    }


    /**
     * 更新赛事名称
     *
     * @param sysRaceName
     * @param bindingResult
     * @return
     */
    @RequiresPermissions("sys:racename:update")
    @PutMapping("/updateRaceName")
    public R updateRaceName(@Valid @RequestBody SysRaceName sysRaceName,
                            BindingResult bindingResult) {

        Assert.isNull(sysRaceName.getId(), "id不能为空");

        if (bindingResult.hasErrors()) {
            log.error("【更新赛事名称】参数不正确:sysGameLevelFrom={}" + sysRaceName);
            throw new SystemException(REnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        return sysRaceNameService.updateRaceName(sysRaceName);
    }


    /**
     * 删除赛事名称
     *
     * @param id
     * @return
     */
    @RequiresPermissions("sys:racename:delete")
    @DeleteMapping("/deleteRaceName/{id}")
    public R deleteRaceName(@PathVariable Integer id) {
        return sysRaceNameService.deleteRaceName(id);
    }

}

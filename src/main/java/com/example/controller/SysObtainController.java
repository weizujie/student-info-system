package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.example.enums.REnum;
import com.example.exception.SystemException;
import com.example.listener.ObtainListener;
import com.example.model.SysObtain;
import com.example.service.SysObtainService;
import com.example.utils.Assert;
import com.example.utils.RUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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


    /**
     * 导入 Excel 文件
     *
     * @param excel
     * @return
     */
    @RequiresPermissions("sys:obtain:import")
    @PostMapping(value = "/importObtainExcel")
    public R importObtainExcel(@RequestParam(value = "excel", required = false) MultipartFile excel) throws IOException {
        List<Object> sysObtainList = EasyExcel.read(excel.getInputStream(), SysObtain.class, new ObtainListener((sysObtainService))).sheet().doReadSync();
        return RUtil.success(sysObtainList);
    }

    /**
     * 导出 Excel 文件
     *
     * @return
     */
    @RequiresPermissions("sys:obtain:export")
    @GetMapping(value = "/exportObtainExcel")
    public void exportObtainExcel(HttpServletResponse response) throws IOException {
        List<SysObtain> obtains = sysObtainService.findAll();
        String fileName = "ObtainExcel";
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), SysObtain.class).sheet("Obtain").doWrite(obtains);
            log.info("下载 ObtainExcel.xlsx 文件成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


}

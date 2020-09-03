package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 获奖统计实体类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
@Data
public class Obtain {

    @ExcelProperty(value = "序号", index = 0)
    private int id;
    // 姓名
    @ExcelProperty(value = "姓名", index = 1)
    private String studentName;
    // 学号
    @ExcelProperty(value = "学号", index = 2)
    private String studentNumber;
    // 专业
    @ExcelProperty(value = "专业", index = 3)
    private String major;
    // 银行卡号(选填)
    @ExcelProperty(value = "银行卡号", index = 4)
    private String cardNumber;
    // 竞赛名称
    @ExcelProperty(value = "竞赛名称", index = 5)
    private String raceName;
    // 赛事范围
    @ExcelProperty(value = "赛事范围", index = 6)
    private String raceScope;
    // 获奖级别
    @ExcelProperty(value = "获奖级别", index = 7)
    private String rank;
    // 指导老师
    @ExcelProperty(value = "指导老师", index = 8)
    private String adviser;
    // 组队情况：个人/团体
    @ExcelProperty(value = "组队情况", index = 9)
    private String teamSituation;
    // 年级
    @ExcelProperty(value = "年级", index = 10)
    private String grade;
    // 获奖时间
    @ExcelProperty(value = "获奖时间", index = 11)
    private String obtainTime;
}

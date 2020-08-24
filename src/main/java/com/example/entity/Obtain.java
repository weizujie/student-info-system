package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * 获奖统计实体类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
@Data
public class Obtain {
    private int id;
    // 姓名
    private String studentName;
    // 学号
    private String studentNumber;
    // 专业
    private String major;
    // 银行卡号(选填)
    private String cardNumber;
    // 竞赛名称
    private String raceName;
    // 赛事范围
    private String raceScope;
    // 获奖级别
    private String rank;
    // 指导老师
    private String adviser;
    // 组队情况：个人/团体
    private String teamSituation;
    // 年级
    private String grade;
    // 获奖时间
    private Date obtainTime;
}

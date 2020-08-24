package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * 学术统计实体类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

@Data
public class Scholarism {
    private int id;
    // 成果：专利/论文
    private String resultName;
    // 年级
    private String grade;
    // 专业
    private String major;
    // 论文名称(选填)
    private String paperName;
    // 专利名称(选填)
    private String patentName;
    // 申请人
    private String applicant;
    // 指导老师(选填)
    private String adviser;
    // 专利号
    private String patentNumber;
    // 论文编号
    private String paperNumber;
    // 申请时间(选填)
    private Date applicationTime;
    // 发表时间(选填)
    private Date postedTime;

}

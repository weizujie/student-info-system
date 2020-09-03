package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ExcelProperty(value = "编号", index = 0)
    private int id;
    // 成果：专利/论文
    @ExcelProperty(value = "成果", index = 1)
    private String resultName;
    // 年级
    @ExcelProperty(value = "年级", index = 2)
    private String grade;
    // 专业
    @ExcelProperty(value = "专业", index = 3)
    private String major;
    // 论文名称(选填)
    @ExcelProperty(value = "论文名称", index = 4)
    private String paperName;
    // 专利名称(选填)
    @ExcelProperty(value = "专利名称", index = 5)
    private String patentName;
    // 申请人
    @ExcelProperty(value = "申请人", index = 6)
    private String applicant;
    // 指导老师(选填)
    @ExcelProperty(value = "指导老师", index = 7)
    private String adviser;
    // 学号
    @ExcelProperty(value = "学号", index = 8)
    private String studentNumber;
    // 期刊(选填)
    @ExcelProperty(value = "期刊", index = 9)
    private String periodical;
    // 期刊号(选填)
    @ExcelProperty(value = "期刊号", index = 10)
    private String serialNumber;
    // 专利号
    @ExcelProperty(value = "专利号", index = 11)
    private String patentNumber;
    // 论文编号
    @ExcelProperty(value = "论文编号", index = 12)
    private String paperNumber;
    // 第一作者
    @ExcelProperty(value = "第一作者", index = 13)
    private String firstAuthor;
    // 通讯作者
    @ExcelProperty(value = "通讯作者", index = 14)
    private String correspondingAuthor;
    // 申请时间
    @ExcelProperty(value = "申请时间", index = 15)
    private String applicationTime;
    // 发表时间(选填)
    @ExcelProperty(value = "发表时间", index = 16)
    private String postedTime;
}

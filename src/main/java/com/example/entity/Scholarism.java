package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 学术统计实体类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

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

    public Scholarism() {
    }

    public Scholarism(int id, String resultName, String grade, String major, String paperName, String patentName, String applicant, String adviser, String studentNumber, String periodical, String serialNumber, String patentNumber, String paperNumber, String firstAuthor, String correspondingAuthor, String applicationTime, String postedTime) {
        this.id = id;
        this.resultName = resultName;
        this.grade = grade;
        this.major = major;
        this.paperName = paperName;
        this.patentName = patentName;
        this.applicant = applicant;
        this.adviser = adviser;
        this.studentNumber = studentNumber;
        this.periodical = periodical;
        this.serialNumber = serialNumber;
        this.patentNumber = patentNumber;
        this.paperNumber = paperNumber;
        this.firstAuthor = firstAuthor;
        this.correspondingAuthor = correspondingAuthor;
        this.applicationTime = applicationTime;
        this.postedTime = postedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPeriodical() {
        return periodical;
    }

    public void setPeriodical(String periodical) {
        this.periodical = periodical;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getFirstAuthor() {
        return firstAuthor;
    }

    public void setFirstAuthor(String firstAuthor) {
        this.firstAuthor = firstAuthor;
    }

    public String getCorrespondingAuthor() {
        return correspondingAuthor;
    }

    public void setCorrespondingAuthor(String correspondingAuthor) {
        this.correspondingAuthor = correspondingAuthor;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(String postedTime) {
        this.postedTime = postedTime;
    }

    @Override
    public String toString() {
        return "Scholarism{" +
                "id=" + id +
                ", resultName='" + resultName + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", paperName='" + paperName + '\'' +
                ", patentName='" + patentName + '\'' +
                ", applicant='" + applicant + '\'' +
                ", adviser='" + adviser + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", periodical='" + periodical + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", patentNumber='" + patentNumber + '\'' +
                ", paperNumber='" + paperNumber + '\'' +
                ", firstAuthor='" + firstAuthor + '\'' +
                ", correspondingAuthor='" + correspondingAuthor + '\'' +
                ", applicationTime='" + applicationTime + '\'' +
                ", postedTime='" + postedTime + '\'' +
                '}';
    }
}

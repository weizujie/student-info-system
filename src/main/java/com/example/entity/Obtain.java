package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 获奖统计实体类
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */

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

    public Obtain() {
    }

    public Obtain(int id, String studentName, String studentNumber, String major, String cardNumber, String raceName, String raceScope, String rank, String adviser, String teamSituation, String grade, String obtainTime) {
        this.id = id;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.major = major;
        this.cardNumber = cardNumber;
        this.raceName = raceName;
        this.raceScope = raceScope;
        this.rank = rank;
        this.adviser = adviser;
        this.teamSituation = teamSituation;
        this.grade = grade;
        this.obtainTime = obtainTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceScope() {
        return raceScope;
    }

    public void setRaceScope(String raceScope) {
        this.raceScope = raceScope;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public String getTeamSituation() {
        return teamSituation;
    }

    public void setTeamSituation(String teamSituation) {
        this.teamSituation = teamSituation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(String obtainTime) {
        this.obtainTime = obtainTime;
    }

    @Override
    public String toString() {
        return "Obtain{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", major='" + major + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", raceName='" + raceName + '\'' +
                ", raceScope='" + raceScope + '\'' +
                ", rank='" + rank + '\'' +
                ", adviser='" + adviser + '\'' +
                ", teamSituation='" + teamSituation + '\'' +
                ", grade='" + grade + '\'' +
                ", obtainTime='" + obtainTime + '\'' +
                '}';
    }
}

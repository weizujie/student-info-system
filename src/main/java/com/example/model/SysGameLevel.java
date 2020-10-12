package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 赛事等级
 *
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

@Data
@Entity
public class SysGameLevel {
    @Id
    @GeneratedValue
    private Integer id;
    private String levelName;
    private String remark;

}



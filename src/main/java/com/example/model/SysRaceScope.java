package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 赛事范围
 *
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */


@Data
@Entity
public class SysRaceScope {

    @Id
    @GeneratedValue
    private Integer id;
    private String raceScope;
    private String remark;

}



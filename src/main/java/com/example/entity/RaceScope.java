package com.example.entity;

import lombok.Data;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

public class RaceScope {

    private Integer id;
    private String raceScope;
    private String comment;

    public RaceScope() {
    }

    public RaceScope(Integer id, String raceScope, String comment) {
        this.id = id;
        this.raceScope = raceScope;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaceScope() {
        return raceScope;
    }

    public void setRaceScope(String raceScope) {
        this.raceScope = raceScope;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "RaceScope{" +
                "id=" + id +
                ", raceScope='" + raceScope + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}



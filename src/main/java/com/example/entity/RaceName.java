package com.example.entity;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */

public class RaceName {

    private Integer id;
    private String raceName;
    private String comment;

    public RaceName() {
    }

    public RaceName(Integer id, String raceName, String comment) {
        this.id = id;
        this.raceName = raceName;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "RaceName{" +
                "id=" + id +
                ", raceName='" + raceName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}



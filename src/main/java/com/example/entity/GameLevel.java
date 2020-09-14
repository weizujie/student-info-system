package com.example.entity;

/**
 * @Author: weizujie
 * @Date: 2020/8/31
 * @Github: https://github.com/weizujie
 */


public class GameLevel {

    private Integer id;
    private String levelName;
    private String comment;

    public GameLevel() {
    }

    public GameLevel(Integer id, String levelName, String comment) {
        this.id = id;
        this.levelName = levelName;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "GameLevel{" +
                "id=" + id +
                ", levelName='" + levelName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}



package com.example.service;

import com.example.entity.CompetitionStatistics;

import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface ICompetitionStatisticsService {
    List<CompetitionStatistics> findAll();

}

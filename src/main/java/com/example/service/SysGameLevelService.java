package com.example.service;

import com.example.model.SysGameLevel;
import com.example.vo.R;
import org.springframework.data.domain.Pageable;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysGameLevelService {

    R selectGameLevelList(String name, Pageable pageable);

    R deleteGameLevel(Integer id);

    R updateGameLevel(SysGameLevel sysGameLevel);

    R saveGameLevel(SysGameLevel sysGameLevel);

    R selectGameLevelDetail(Integer id);
}

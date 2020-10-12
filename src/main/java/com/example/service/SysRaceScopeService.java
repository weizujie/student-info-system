package com.example.service;

import com.example.model.SysRaceScope;
import com.example.vo.R;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */
public interface SysRaceScopeService {
    R saveRaceScope(SysRaceScope sysRaceScope);

    R selectRaceScopeList(String scope, Pageable pageable);

    R updateRaceScope(SysRaceScope sysRaceScope);

    R deleteRaceScope(Integer id);

    R selectRaceScopeDetail(Integer id);
}

package com.example.service;

import com.example.model.SysRaceName;
import com.example.vo.R;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */
public interface SysRaceNameService {
    R saveRaceName(SysRaceName sysRaceName);

    R selectRaceNameList(String name, Pageable pageable);

    R updateRaceName(SysRaceName sysRaceName);

    R deleteRaceName(Integer id);

    R selectRaceNameDetail(Integer id);
}

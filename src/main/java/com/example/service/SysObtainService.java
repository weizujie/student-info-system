package com.example.service;

import com.example.model.SysObtain;
import com.example.vo.R;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */
public interface SysObtainService {

    R saveObtain(SysObtain sysObtain);

    R selectObtainList(String name, Pageable pageable);

    R updateObtain(SysObtain sysObtain);

    R deleteObtain(Integer id);

    R selectObtainDetail(Integer id);
}

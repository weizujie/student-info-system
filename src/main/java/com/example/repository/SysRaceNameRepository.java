package com.example.repository;

import com.example.model.SysRaceName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysRaceNameRepository extends JpaRepository<SysRaceName, Integer> {
    SysRaceName findByRaceName(String raceName);

    Page<SysRaceName> findAll(Specification<SysRaceName> specification, Pageable pageable);
}

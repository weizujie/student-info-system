package com.example.repository;

import com.example.model.SysRaceScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */
public interface SysRaceScopeRepository extends JpaRepository<SysRaceScope, Integer> {
    SysRaceScope findByRaceScope(String raceScope);

    Page<SysRaceScope> findAll(Specification<SysRaceScope> specification, Pageable pageable);
}

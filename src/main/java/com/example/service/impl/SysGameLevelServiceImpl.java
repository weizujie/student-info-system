package com.example.service.impl;

import com.example.enums.REnum;
import com.example.model.SysGameLevel;
import com.example.repository.SysGameLevelRepository;
import com.example.service.SysGameLevelService;
import com.example.utils.JPAUtil;
import com.example.utils.RUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/10/8
 * @Github: https://github.com/weizujie
 */

@Service
@Transactional
@Slf4j
public class SysGameLevelServiceImpl implements SysGameLevelService {

    @Autowired
    private SysGameLevelRepository sysGameLevelRepository;


    @Override
    public R selectGameLevelList(String name, Pageable pageable) {
        Specification<SysGameLevel> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (StringUtils.isNoneBlank(name)) {
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return RUtil.success(sysGameLevelRepository.findAll(specification, pageable));
    }

    @Override
    public R deleteGameLevel(Integer id) {
        sysGameLevelRepository.delete(id);
        return RUtil.success();
    }

    @Override
    public R updateGameLevel(SysGameLevel sysGameLevel) {
        SysGameLevel sysGameLevelSave = sysGameLevelRepository.save(sysGameLevel);
        return RUtil.success(sysGameLevelSave);
    }

    @Override
    public R saveGameLevel(SysGameLevel sysGameLevel) {

        /*判断该赛事等级是否存在*/
        if (sysGameLevelRepository.findByLevelName(sysGameLevel.getLevelName()) != null) {
            log.error(sysGameLevel.getLevelName());
            return RUtil.error(REnum.GAMELEVEL_EXIST.getCode(), REnum.GAMELEVEL_EXIST.getMessage());
        }

        SysGameLevel sysGameLevelSave = sysGameLevelRepository.save(sysGameLevel);
        log.info("赛事等级保存：sysGameLevelSave = {}" + sysGameLevelSave);
        return RUtil.success(sysGameLevelSave);
    }

    @Override
    public R selectGameLevelDetail(Integer id) {
        SysGameLevel sysGameLevelById = sysGameLevelRepository.findOne(id);
        return RUtil.success(sysGameLevelById);
    }

}

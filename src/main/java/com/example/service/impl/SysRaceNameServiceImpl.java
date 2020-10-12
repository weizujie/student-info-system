package com.example.service.impl;

import com.example.enums.REnum;
import com.example.model.SysGameLevel;
import com.example.model.SysRaceName;
import com.example.repository.SysRaceNameRepository;
import com.example.service.SysRaceNameService;
import com.example.utils.JPAUtil;
import com.example.utils.RUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weizujie
 * @Date: 2020/10/11
 * @Github: https://github.com/weizujie
 */

@Service
@Transactional
@Slf4j
public class SysRaceNameServiceImpl implements SysRaceNameService {

    @Autowired
    private SysRaceNameRepository sysRaceNameRepository;


    @Override
    public R saveRaceName(SysRaceName sysRaceName) {

        /*判断该赛事名称是否存在*/
        if (sysRaceNameRepository.findByRaceName(sysRaceName.getRaceName()) != null) {
            log.error(sysRaceName.getRaceName());
            return RUtil.error(REnum.RACENAME_EXIST.getCode(), REnum.RACENAME_EXIST.getMessage());
        }

        SysRaceName sysRaceNameSave = sysRaceNameRepository.save(sysRaceName);
        log.info("赛事名称保存：sysRaceNameSave = {}" + sysRaceNameSave);
        return RUtil.success(sysRaceNameSave);
    }

    @Override
    public R selectRaceNameList(String name, Pageable pageable) {
        Specification<SysRaceName> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (StringUtils.isNoneBlank(name)) {
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return RUtil.success(sysRaceNameRepository.findAll(specification, pageable));
    }

    @Override
    public R updateRaceName(SysRaceName sysRaceName) {
        SysRaceName sysRaceNameSave = sysRaceNameRepository.save(sysRaceName);
        return RUtil.success(sysRaceNameSave);
    }

    @Override
    public R deleteRaceName(Integer id) {
        sysRaceNameRepository.delete(id);
        return RUtil.success();
    }

    @Override
    public R selectRaceNameDetail(Integer id) {
        SysRaceName sysRaceNameById = sysRaceNameRepository.findOne(id);
        return RUtil.success(sysRaceNameById);
    }
}

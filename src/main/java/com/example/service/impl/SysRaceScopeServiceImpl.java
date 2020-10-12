package com.example.service.impl;

import com.example.enums.REnum;
import com.example.model.SysRaceName;
import com.example.model.SysRaceScope;
import com.example.repository.SysRaceScopeRepository;
import com.example.service.SysRaceScopeService;
import com.example.utils.JPAUtil;
import com.example.utils.RUtil;
import com.example.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
public class SysRaceScopeServiceImpl implements SysRaceScopeService {

    @Autowired
    private SysRaceScopeRepository sysRaceScopeRepository;

    @Override
    public R saveRaceScope(SysRaceScope sysRaceScope) {
        /*判断该赛事范围是否存在*/
        if (sysRaceScopeRepository.findByRaceScope(sysRaceScope.getRaceScope()) != null) {
            log.error(sysRaceScope.getRaceScope());
            return RUtil.error(REnum.RACESCOPE_EXITS.getCode(), REnum.RACESCOPE_EXITS.getMessage());
        }

        SysRaceScope sysRaceScopeSave = sysRaceScopeRepository.save(sysRaceScope);
        log.info("赛事范围保存：sysRaceScopeSave = {}" + sysRaceScopeSave);
        return RUtil.success(sysRaceScopeSave);
    }

    @Override
    public R selectRaceScopeList(String name, Pageable pageable) {
        Specification<SysRaceScope> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (StringUtils.isNoneBlank(name)) {
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return RUtil.success(sysRaceScopeRepository.findAll(specification, pageable));
    }

    @Override
    public R updateRaceScope(SysRaceScope sysRaceScope) {
        SysRaceScope sysRaceScopeSave = sysRaceScopeRepository.save(sysRaceScope);
        return RUtil.success(sysRaceScopeSave);
    }

    @Override
    public R deleteRaceScope(Integer id) {
        sysRaceScopeRepository.delete(id);
        return RUtil.success();
    }

    @Override
    public R selectRaceScopeDetail(Integer id) {
        SysRaceScope sysRaceScopeById = sysRaceScopeRepository.findOne(id);
        return RUtil.success(sysRaceScopeById);
    }
}

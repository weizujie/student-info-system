package com.example.service.impl;

import com.example.model.SysObtain;
import com.example.repository.SysObtainRepository;
import com.example.service.SysObtainService;
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
public class SysObtainServiceImpl implements SysObtainService {

    @Autowired
    private SysObtainRepository sysObtainRepository;

    @Override
    public R saveObtain(SysObtain sysObtain) {
        SysObtain sysObtainSave = sysObtainRepository.save(sysObtain);
        return RUtil.success(sysObtainSave);
    }

    @Override
    public R selectObtainList(String name, Pageable pageable) {
        Specification<SysObtain> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (StringUtils.isNoneBlank(name)) {
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return RUtil.success(sysObtainRepository.findAll(specification, pageable));
    }

    @Override
    public R updateObtain(SysObtain sysObtain) {
        SysObtain sysObtainSave = sysObtainRepository.save(sysObtain);
        return RUtil.success(sysObtainSave);
    }

    @Override
    public R deleteObtain(Integer id) {
        sysObtainRepository.delete(id);
        return RUtil.success();
    }

    @Override
    public R selectObtainDetail(Integer id) {
        SysObtain sysObtainById = sysObtainRepository.findOne(id);
        return RUtil.success(sysObtainById);
    }

    @Override
    public List<SysObtain> findAll() {
        return sysObtainRepository.findAll();
    }
}

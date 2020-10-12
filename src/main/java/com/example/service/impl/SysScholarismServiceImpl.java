package com.example.service.impl;

import com.example.model.SysScholarism;
import com.example.repository.SysScholarismRepository;
import com.example.service.SysScholarismService;
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
public class SysScholarismServiceImpl implements SysScholarismService {

    @Autowired
    private SysScholarismRepository sysScholarismRepository;


    @Override
    public R saveScholarism(SysScholarism sysScholarism) {
        SysScholarism sysScholarismSave = sysScholarismRepository.save(sysScholarism);
        return RUtil.success(sysScholarismSave);
    }

    @Override
    public R selectScholarismList(String name, Pageable pageable) {
        Specification<SysScholarism> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if (StringUtils.isNoneBlank(name)) {
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class), JPAUtil.like(name)));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return RUtil.success(sysScholarismRepository.findAll(specification, pageable));
    }

    @Override
    public R updateScholarism(SysScholarism sysScholarism) {
        SysScholarism sysScholarismSave = sysScholarismRepository.save(sysScholarism);
        return RUtil.success(sysScholarismSave);
    }

    @Override
    public R deleteScholarism(Integer id) {
        sysScholarismRepository.delete(id);
        return RUtil.success();
    }

    @Override
    public R selectScholarismDetail(Integer id) {
        SysScholarism sysScholarismById = sysScholarismRepository.findOne(id);
        return RUtil.success(sysScholarismById);
    }

    @Override
    public List<SysScholarism> findAll() {
        return sysScholarismRepository.findAll();
    }
}

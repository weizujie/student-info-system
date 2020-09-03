package com.example.mapper;

import com.example.entity.Obtain;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 获奖 Mapper
 *
 * @Author: weizujie
 * @Date: 2020/8/23
 * @Github: https://github.com/weizujie
 */
public interface ObtainMapper {
    List<Obtain> findAll();

    List<Obtain> getData();

    void addObtain(Obtain obtain);

    Obtain findById(@Param("id") Integer id);

    List<Obtain> search(@Param("studentName") String studentName);

    void updateObtain(Obtain obtain);

    void deleteById(Integer id);

    void saveAll(List<Obtain> obtain);
}

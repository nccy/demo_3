package com.hnust.service;

import com.hnust.entity.School;

import java.util.List;

/**
 * @author 长夜
 * @date 2023/3/31 15:37
 */
public interface SchoolService {
    School selectById(Integer id);
    List<School> selectAll();
}

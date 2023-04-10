package com.hnust.dao;

import com.hnust.entity.Course;
import com.hnust.entity.School;

import java.util.List;
import java.util.Map;

/**
 * @author 长夜
 * @date 2023/3/31 15:31
 */
public interface SchoolDao {
    School selectById(Integer id);
    List<School> selectAll();
}

package com.hnust.service.impl;

import com.hnust.dao.CourseDao;
import com.hnust.entity.Course;
import com.hnust.entity.School;
import com.hnust.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 长夜
 * @date 2023/3/22 21:49
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> selectAll() {
        return courseDao.selectAll();
    }
    @Override
    public Course selectById(Integer id) {
        return courseDao.selectById(id);
    }

    @Override
    public Boolean update(Course course) {
        courseDao.update(course);
        return true;
    }

    @Override
    public List<Course> selectByscName(String name) {
        return courseDao.selectByscName(name);
    }

    @Override
    public Boolean insertAutoId(Course course) {
        courseDao.insertAutoId(course);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        courseDao.deleteById(id);
        return true;
    }

    @Override
    public String selectImage(Integer id) {
        return courseDao.selectImage(id);
    }
}

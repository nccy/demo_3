package com.hnust.service.impl;

import com.hnust.dao.CourseDao;
import com.hnust.dao.SchoolDao;
import com.hnust.entity.School;
import com.hnust.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 长夜
 * @date 2023/3/31 15:37
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<School> selectAll() {
        return schoolDao.selectAll();
    }

    @Override
    public School selectById(Integer id) {
        return schoolDao.selectById(id);
    }
}

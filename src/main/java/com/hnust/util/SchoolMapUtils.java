package com.hnust.util;

import com.hnust.entity.School;
import com.hnust.service.impl.SchoolServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 长夜
 * @date 2023/3/31 15:53
 */
public class SchoolMapUtils {
    public static Map<Integer,String> getSchoolMap()
    {
        SchoolServiceImpl sp = new SchoolServiceImpl();
        List<School> schools=sp.selectAll();
        Map<Integer,String> m =new HashMap<Integer,String>();
        for(School s : schools)
        {
            m.put(s.getId(),s.getSchoolName());
        }
        return m;
    }
}

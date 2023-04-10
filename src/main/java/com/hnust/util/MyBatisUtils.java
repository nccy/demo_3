package com.hnust.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author 长夜
 * @date 2023/3/20 20:05
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    // 初始化SqlSessionFactory对象
    static {
        try {
// 使⽤MyBatis提供的Resources类加载MyBatis的配置⽂件
            Reader reader =
                    Resources.getResourceAsReader("applicationContext.xml");
// 构建SqlSessionFactory⼯⼚
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取SqlSession对象的静态⽅法
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}

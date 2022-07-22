package com.zylai.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/20/15:39
 * @Description:
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            //1.获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.获取SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //3.获取SqlSessionFactory对象，根据核心配置文件的输入流
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //4.获取sql的会话对象SqlSession，是MyBatis提供的操作数据库的对象
            //7.调用有参的方法，设置自动提交事务。空参方法默认不自动提交
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}

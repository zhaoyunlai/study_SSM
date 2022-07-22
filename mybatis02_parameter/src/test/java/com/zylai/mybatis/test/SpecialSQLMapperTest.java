package com.zylai.mybatis.test;

import com.zylai.mybatis.mapper.SpecialSQLMapper;
import com.zylai.mybatis.pojo.User;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/15:29
 * @Description:
 */
public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("o");
        list.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("5,7");
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "xixi", "2323", 20, "女", "1@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}

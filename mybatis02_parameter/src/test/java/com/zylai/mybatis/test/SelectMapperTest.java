package com.zylai.mybatis.test;

import com.zylai.mybatis.mapper.SelectMapper;
import com.zylai.mybatis.pojo.User;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/11:57
 * @Description:
 */
public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

//        如果返回值只有一条，底层调用的是selectOne方法。如果返回多条，就会报错
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
        //查询一条数据转换为map集合的结果，key为字段名，value为字段值。
        //如果某个字段没有值（值为null），那么这个键值对不会放到map中
        //{password=123456, gender=男, id=1, age=23, email=123@qq.com, username=admin1}
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMapList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getAllUserToMapList();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
//        {1={password=123456, gender=男, id=1, age=23, email=123@qq.com, username=admin1},
//        2={password=123456, gender=男, id=2, age=23, email=123@qq.com, username=admin},
//        4={password=123456, gender=男, id=4, age=23, email=123@qq.com, username=admin},
//        5={password=123, gender=女, id=5, age=33, email=3232@163.com, username=xiaoming},
//        7={password=123, gender=女, id=7, age=33, email=3232@163.com, username=xiaoming},
//        8={password=123, id=8, username=jack},
//        9={id=9}}
    }
}

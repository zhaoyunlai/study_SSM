package com.zylai.mybatis.test;

import com.zylai.mybatis.mapper.UserMapper;
import com.zylai.mybatis.pojo.User;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/20/14:27
 * @Description:
 */
public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        //1.获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSessionFactory对象，根据核心配置文件的输入流
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4.获取sql的会话对象SqlSession，是MyBatis提供的操作数据库的对象
        //7.调用有参的方法，设置自动提交事务。空参方法默认不自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5.获取UserMapper的代理实现类对象，底层使用代理模式实现
        //通过代理对象实现接口的方法，当调用接口的方法时，
        // 其实执行了SqlSession的具体方法，然后其会根据接口的全类名及方法名
        //定位到映射文件对应的SQL，如下面说的一样
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6.调用mapper接口中的方法，实现添加用户信息的功能
        int res = mapper.insertUser();
        System.out.println("结果"+res);

        //注意：这里使用Mapper接口的代理对象其实是最终的一种方法，通过代理对象重写接口的方法
        //本质上，就是调用了接口的方法，实现类中使用SqlSession的方法
        // 提供sql的唯一标识找到SQL并执行，唯一标识是namespace.sqlId。
        // 这里就不需要用到接口了，接口的名称和方法只是作为唯一id，完全可以换成其他的。
//        int res1 = sqlSession.insert("com.zylai.mybatis.mapper.UserMapper.insertUser");
//        System.out.println("结果："+res1);

        /*
        总结：
        1.创建mapper接口的代理对象
        2.代理对象重写了mapper接口中的方法
        3.执行SqlSession的方法，参数是sql的唯一标识
        4.返回结果
         */


        //7.提交事务，使用空参的SqlSession，需要自己进行事务的控制
        //sqlSession.commit();
        //8.关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }
}

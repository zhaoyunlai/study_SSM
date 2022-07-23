package com.zylai.mybatis.test;

import com.zylai.mybatis.mapper.EmpMapper;
import com.zylai.mybatis.pojo.Emp;
import com.zylai.mybatis.pojo.EmpExample;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/23/10:28
 * @Description:
 */
public class MBGTest {

    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据主键查
//        Emp emp = mapper.selectByPrimaryKey(2);
//        System.out.println(emp);

        //查询所有数据
//        List<Emp> list  =  mapper.selectByExample(null);
//        list.forEach(System.out::println);

        // 条件查询

        EmpExample empExample = new EmpExample();
        //and方法
        empExample.createCriteria().andAgeLessThan(25).andGenderEqualTo("女");
        //or方法，这里的or直接拼接上了之前的查询方法
        empExample.or().andEmpNameEqualTo("哈哈");
        List<Emp> list  =  mapper.selectByExample(empExample);
        list.forEach(System.out::println);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(9, "小黑1", null, "男");
        //测试普通修改
//        mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        for (int i = 0; i < 30; i++) {
            Emp emp = new Emp(null, "aa" + i, 10 + i, "女");
            mapper.insert(emp);
        }
    }


}

package com.zylai.mybatis.test;

import com.zylai.mybatis.mapper.DeptMapper;
import com.zylai.mybatis.mapper.EmpMapper;
import com.zylai.mybatis.pojo.Dept;
import com.zylai.mybatis.pojo.Emp;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/17:30
 * @Description:
 */
public class ResultMapTest {

    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(4);
        System.out.println(emp.getEmpName());
    }

    @Test
    public void testGetDeptAndEmpByDept(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
//        延迟加载
        System.out.println(dept.getDeptName());
    }
}

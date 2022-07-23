package com.zylai.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zylai.mybatis.mapper.EmpMapper;
import com.zylai.mybatis.pojo.Emp;
import com.zylai.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/23/11:29
 * @Description:
 */
public class PageTest {

    /**
     * PageInfo{
     * pageNum=2, pageSize=4, size=4,
     * startRow=5, endRow=8,total=30, pages=8,
     * list=Page{count=true, pageNum=2, pageSize=4,
     * startRow=4, endRow=8, total=30, pages=8, reasonable=false,pageSizeZero=false}
     * [Emp{empId=5, empName='aa4', age=14, gender='女', deptId=null},
     * Emp{empId=6, empName='aa5', age=15, gender='女', deptId=null},
     * Emp{empId=7, empName='aa6', age=16, gender='女', deptId=null},
     * Emp{empId=8, empName='aa7', age=17, gender='女', deptId=null}],
     * prePage=1, nextPage=3, isFirstPage=false, isLastPage=false,
     * hasPreviousPage=true, hasNextPage=true, navigatePages=5,
     * navigateFirstPage=1, navigateLastPage=5,
     * navigatepageNums=[1, 2, 3, 4, 5]
     * }
     */

    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能，相当于一个拦截器，拦截查询的请求实现分页
        Page<Object> page = PageHelper.startPage(5, 4);
        //实际会执行两条sql，第一条查询总记录数。第二条才是分页查询
        List<Emp> list = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        System.out.println(pageInfo);
        list.forEach(System.out::println);

        //page继承了ArrayList，本质上是一个集合。里面有许多我们用到的信息
        System.out.println(page);

    }
}

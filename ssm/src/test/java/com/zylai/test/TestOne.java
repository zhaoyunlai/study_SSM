package com.zylai.test;

import com.zylai.ssm.pojo.Employee;
import com.zylai.ssm.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/02/16:37
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration(value = {"classpath:spring.xml"})
public class TestOne {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            employeeService.addEmployee(new Employee(null,"a"+i,2*i,"女","aa@163.com"));
        }
    }
}

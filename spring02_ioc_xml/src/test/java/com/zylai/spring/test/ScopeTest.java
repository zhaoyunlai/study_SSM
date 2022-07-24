package com.zylai.spring.test;

import com.zylai.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/16:13
 * @Description:
 */
public class ScopeTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student studentOne = ioc.getBean(Student.class);
        Student studentTwo = ioc.getBean(Student.class);

        System.out.println(studentOne == studentTwo);
    }
}

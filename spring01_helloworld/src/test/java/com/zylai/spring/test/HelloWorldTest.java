package com.zylai.spring.test;

import com.zylai.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/10:57
 * @Description:
 */
public class HelloWorldTest {

    @Test
    public void testHello(){
        //获取IOC容器，使用ClassPathXmlApplicationContext根据类路径获取对象
        //为什么可以直接通过名称访问呢？因为resource和java最终是加载到了一个目录下
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取IOC容器中的bean对象
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }
}

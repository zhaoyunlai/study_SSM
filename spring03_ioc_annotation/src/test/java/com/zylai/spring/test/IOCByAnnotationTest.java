package com.zylai.spring.test;

import com.zylai.spring.controller.UserController;
import com.zylai.spring.dao.UserDao;
import com.zylai.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/18:24
 * @Description:
 */
public class IOCByAnnotationTest {

    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 这四个注解本质和功能上完全一样，后面三个相当于Component改了个名字
     * 但是对于开发人员便于理解
     *
     * 通过注解加扫描所配置的bean的id，默认值为类名的小驼峰，即类名的首字母为小写的结果
     * 注意，接口应该是其实现类
     * 可以通过标识组件注解的value属性设置bean的自定义的id
     *
     * @Autowired: 实现自动装配的注解
     * 1、能够标识的
     *
     *
     */

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController user = ioc.getBean(UserController.class);
        System.out.println(user);

        //默认的id，为类名的小驼峰
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

    @Test
    public void test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController user = ioc.getBean(UserController.class);

        user.saveUser();
    }
}

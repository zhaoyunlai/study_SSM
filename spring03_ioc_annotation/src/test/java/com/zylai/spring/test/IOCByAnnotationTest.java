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
     * 1、能够标识的位置
     *   1.成员变量上，此时不需要设置成员变量的set方法
     *   2.set方法上
     *   3.为当前成员变量赋值的有参构造器上
     * 2、@Autowired注解的原理
     *  1.默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     *  2.若有多个类型匹配的bean，此时会自动转化为byName的方式来实现自动装配的效果
     *  即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
     *  3.若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean
     *  且这些bean的id和要复制的属性的属性名都不一致，此时抛异常：
     *  4.此时可以在要赋值的属性上，添加一个注解@Qualifier("value")
     *  通过该注解的value属性值，指定某个bean的id，然后将这个bean为属性赋值
     *
     *  注意：若IOC容器中没有任何一个类型匹配bean，此时抛出异常：NoSuchBeanDefinitionException
     *  在@Autowired注解中有个required属性，默认值为true，要求必须完成自动装配
     *  可以将required设置为false，此时能装配则装配，无法装配则使用属性的默认值
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

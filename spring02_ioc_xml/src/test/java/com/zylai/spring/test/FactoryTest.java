package com.zylai.spring.test;

import com.zylai.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/16:53
 * @Description:
 */
public class FactoryTest {

    @Test
    public void test(){
//         在配置文件中只需要配置FactoryBean即可
//        当把FactoryBean的实现类配置为bean时，
//        真正交给IOC容器管理的对象，是FactoryBean工厂中getObject方法返回的对象
//        也就是说，省略了传统的工厂模式从工厂实例中获取产品的步骤，
//        而是直接把工厂的产品交给了ioc容器管理
//        另外，还可以设置是否为单例
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}

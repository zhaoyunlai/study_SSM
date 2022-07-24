package com.zylai.spring.test;

import com.zylai.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/16:29
 * @Description:
 */
public class LifeCycleTest {

    /**
     * 1、实例化，调用无参构造
     * 2、实例注入，调用set
     * 3、后置处理的postProcessBeforeInitialization方法
     * 4、初始化，需要通过bean的init-method属性指定初始化方法
     *    使用bean
     * 5、后置处理的postProcessAfterInitialization方法
     * 6、IOC容器关闭时销毁，需要使用bean的destroy-method属性指定销毁方法
     *
     * bean的作用域是单例时，在创建IOC容器时，bean实例就会被创建
     * 作用域是多例时，只有在获取bean实例时才会被创建
     *
     * bean的后置处理器会在生命周期的初始化前后添加额外的操作，
     * 需要实现BeanPostProcessor接口，
     * 且配置到IOC容器中，需要注意的是，bean后置处理器不是单独针对某一个bean生效，
     * 而是针对IOC容器中所有bean都会执行
     */
    @Test
    public void test(){
        //ClassPathXmlApplicationContext扩展了刷新和销毁的子方法
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println("获取bean并使用："+user);
        ioc.close();
    }
}

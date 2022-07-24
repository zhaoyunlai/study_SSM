package com.zylai.spring.test;

import com.zylai.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/17:12
 * @Description:
 */
public class AutowireByXMLTest {

    /**
     * 自动装配：
     * 根据指定的策略，在IOC容器中匹配某个bean，自动为为bean中的类类型的属性
     * 或者接口类型的属性赋值
     *
     * 可以通过bean标签的autowire属性设置自动装配的策略
     * 自动装配的策略：
     * 1、no,default：表示不装配，即bean中的属性不会自动匹配某个bean为某个属性赋值
     * 2、byType：根据赋值的属性的类型，在IOC容器中匹配某个bean为属性赋值
     * 异常情况：
     * 1、IOC中一个类型都匹配不上：属性就不会装配，使用默认值
     * 2、有多个类型的bean，此时会抛出异常
     * 总结：当使用ByType实现自动装配时，IOC容器中有且仅有一个类型匹配的bean能够为属性赋值
     * 3、byName：将要赋值的属性的属性名作为bean的id在IOC容器中匹配某个bean，为属性赋值
     * 总结：当类型匹配的bean有多个时，此时可以使用byName实现自动装配
     *
     * 通过xml文件的自动装配，在bean标签中设置属性，那么这个bean中所有的属性都会自动装配
     */


    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);

        userController.saveUser();
    }
}

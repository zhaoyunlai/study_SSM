package com.zylai.spring.test;

import com.zylai.spring.pojo.Clazz;
import com.zylai.spring.pojo.Person;
import com.zylai.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/11:13
 * @Description:
 */
public class IOCByXMLTest {

    /**
     * 获取bean的三种方式
     * 1、根据bean的id获取
     * 2、根据bean的类型获取
     * 注意：要求ioc容器中有且仅有一个与之匹配的bean
     *若没有任何一个类型匹配的bean，抛出NoSuchBeanDefinitionException
     *若有多个类型匹配的bean，抛出NoUniqueBeanDefinitionException
     * 3、根据bean的id和类型获取
     *
     * 以后用的最多的就是第二种方式，一个类型的bean只需要配置一次就可以了，如果真的需要多个实例，
     * 那么配置时加上scope属性选择多例就可以了
     *
     * 在IOC容器中通过工厂模式和反射技术创建对象，所以需要对象的无参构造器
     * xml文件中不能写接口，很简单，接口没有实例对象，也没有无参构造器
     *
     * 接口
     *如果组件类实现了接口，根据接口类型可以获取 bean 吗？
     * 可以，前提是bean唯一
     *如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？
     * 不行，因为bean不唯一
     *
     * 结论：
     * 根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：
     * 『对象 instanceof 指定的类
     * 型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。
     * 即通过bean的类型、bean所继承的类的类型、bean所实现的接口的类型都可以获取bean
     */
    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        //获取bean
//        1.通过bean的id获取
//        Student studentOne = (Student) ioc.getBean("studentOne");
//        2.通过类的Class对象获取
//        Student studentOne = ioc.getBean(Student.class);
        //3.通过类型和id获取
        Student studentOne = ioc.getBean("studentOne",Student.class);
        System.out.println(studentOne);

        //通过接口获取实例
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testDI1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
//        Student student = ioc.getBean("studentTwo", Student.class);
        Student student = ioc.getBean("studentSeven", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI2(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazz = ioc.getBean("clazzTwo", Clazz.class);
        System.out.println(clazz);
    }
}

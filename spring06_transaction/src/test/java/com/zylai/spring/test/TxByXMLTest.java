package com.zylai.spring.test;

import com.zylai.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/19:03
 * @Description:
 *
 * 声明式事务的配置步骤：
 * 1、在spring的配置文件中配置事务管理器
 * 2、开启事务的注解驱动
 * 3、在需要被事务管理的方法上，添加@Transactional注解，该方法就会被事务管理
 * 该注解也可以加到类上，那么这个类中所有的方法都会被事务管理
 *
 */

//指定当前测试类在spring的测试环境中执行，此时就可以通过注入的方法直接获取IOC容器的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);

//        bookController.checkout(1,new Integer[]{1,2});
    }
}

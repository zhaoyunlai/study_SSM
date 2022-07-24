package com.zylai.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/15:32
 * @Description:
 */
public class DataSourceTest {

    @Test
    public void test() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}

package com.zylai.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/16:40
 * @Description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor-->后置处理postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //此方法在bean的生命周期初始化之后执行
        System.out.println("MyBeanPostProcessor-->后置处理postProcessAfterInitialization");
        return bean;
    }
}

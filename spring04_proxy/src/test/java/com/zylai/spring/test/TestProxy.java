package com.zylai.spring.test;

import com.zylai.spring.proxy.Calculator;
import com.zylai.spring.proxy.CalculatorImpl;
import com.zylai.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/25/19:07
 * @Description:
 *
 * 动态代理有两种：
 * 1.jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
 * 在com.sun.proxy包下，类名为$proxy2
 * 2.cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
 */
public class TestProxy {

    @Test
    public void testStaticProxy(){
//        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
//        calculatorStaticProxy.add(1,3);

        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);
//        proxy.div(1,0);
    }
}

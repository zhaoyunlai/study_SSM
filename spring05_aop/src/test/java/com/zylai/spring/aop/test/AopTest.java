package com.zylai.spring.aop.test;

import com.zylai.spring.aop.annotation.Calculator;
import com.zylai.spring.aop.annotation.CalculatorImpl;
import com.zylai.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/11:09
 * @Description:
 */
public class AopTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //这里获取不到获取到这个目标对象，只能使用代理类对象
//        CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);

        //所以通过接口获取，因为代理对象也实现了这个接口，我们不能获取目标对象，这里就会获取代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);


//        calculator.sub(1,2);

    }
}

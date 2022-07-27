package com.zylai.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/15:51
 * @Description:
 */
@Aspect
@Component
//设置优先级，数字越小，优先级越高
@Order(value = 1)
public class ValidateAspect {

    @Pointcut("execution(* com.zylai.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect --> 前置通知");
    }
}

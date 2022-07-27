package com.zylai.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/10:57
 * @Description:
 *
 * 1. 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知，在目标方法执行之前执行
 * @After：后置通知，在目标对象方法的finally子句中执行
 * @AfterReturning：返回通知，在目标对象方法返回值之后执行
 * @AfterThrowing：异常通知，在目标对象方法的catch子句中执行
 *
 * 2. 切入点表达式：设置在表示通知的注解的value属性中
 * "execution(public int com.zylai.spring.aop.annotation.CalculatorImpl.add(int,int))"
 * "execution(* com.zylai.spring.aop.annotation.*.*(..))"
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示包下所有的类
 * 第三个*表示类中任意的方法
 * ..表示任意的参数列表
 *
 * 3.重用连接点表达式
 * //声明一个公共的切入点表达式
 * @Pointcut("execution(* com.zylai.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut(){}
 * 使用方式：  @After("pointCut()")
 *
 *
 * 4. 获取连接点信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应的方法信息
 *  //获取连接点对应方法的签名信息
 *  Signature signature = joinPoint.getSignature();
 *  //获取连接点所对应的参数
 *  Object[] args = joinPoint.getArgs();
 *
 *  5.切面的优先级
 *  可以通过@Order注解的value属性设置优先级，默认值为Integer.MAX
 *  value值越小优先级越高
 */
@Component
@Aspect//将当前组件表示为切面
public class LoggerAspect {

    @Pointcut("execution(* com.zylai.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}


//    @Before("execution(public int com.zylai.spring.aop.annotation.CalculatorImpl.add(int,int))")
    //表示这个类下所有的方法，用*表示所有，参数列表用..表示所有的参数列表
//    @Before("execution(* com.zylai.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息（签名信息就是方法的声明信息）
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，前置通知，方法："+signature.getName()+",参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的签名信息（签名信息就是方法的声明信息）
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，后置通知，方法："+signature.getName()+"，执行完毕");
    }

    //在返回通知中若要获取目标对象方法的返回值，只需要通过注解的returning属性值
    //就可以将通知方法的某个参数指定为接收目标对象方法的返回值
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，返回通知，方法："+signature.getName()+"，结果："+result);
    }

    //在返回通知中若要获取目标对象方法的异常，只需要通过注解的throwing属性值
    //就可以将通知方法的某个参数指定为接收目标对象方法出现的异常
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，异常通知，方法："+signature.getName()
        +"异常："+ex);
    }


    @Around("pointCut()")
    //环绕通知的方法返回值一定要和目标方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}

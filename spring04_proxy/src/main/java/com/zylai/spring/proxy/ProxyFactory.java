package com.zylai.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/25/19:13
 * @Description: 动态生成目标类的代理类
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy(){

        //使用JDK动态代理
        /**
         * 必须给出类加载器，根据类加载器来创建类
         * ClassLoader loader：指定目标对象使用的类加载器
         * Class<?>[] interfaces：获取目标对象实现的所有接口的class对象的数组
         * InvocationHandler h ：设置代理类中的抽象方法如何重写
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {

            //这里是设置代理类中的方法如何重写
            //proxy:表示代理对象，method表示要执行的方法，args表示要执行的方法的参数列表
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                try {
                    System.out.println("日志，方法："+method.getName()+",参数："+ Arrays.toString(args));
                    //调用目标对象的方法
                    res = method.invoke(target, args);
                    System.out.println("日志，方法："+method.getName()+",结果："+res);
                    return res;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志，方法："+method.getName()+",异常："+e);
                } finally {
                    System.out.println("日志，方法："+method.getName()+",方法执行完毕");
                }
                return res;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}

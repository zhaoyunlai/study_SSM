package com.zylai.spring.proxy;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/25/19:00
 * @Description:
 */
public class CalculatorStaticProxy implements Calculator{

    //将被代理对象声明为成员变量
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("日志，方法：add，参数："+i+","+j);
        int res = calculator.add(i,j);
        System.out.println("日志，方法：add，结果："+res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("日志，方法：sub，参数："+i+","+j);
        int res = calculator.sub(i,j);
        System.out.println("日志，方法：sub，结果："+res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("日志，方法：mul，参数："+i+","+j);
        int res = calculator.mul(i,j);
        System.out.println("日志，方法：mul，结果："+res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("日志，方法：div，参数："+i+","+j);
        int res = calculator.div(i,j);
        System.out.println("日志，方法：div，结果："+res);
        return res;
    }
}

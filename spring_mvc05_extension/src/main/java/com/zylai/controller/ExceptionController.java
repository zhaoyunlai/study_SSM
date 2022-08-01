package com.zylai.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/12:35
 * @Description:
 */
//将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String exceptionHandler(Model model,Throwable ex){
        //ex表示控制器方法出现的异常
        model.addAttribute("ex",ex);
        return "error";
    }
}

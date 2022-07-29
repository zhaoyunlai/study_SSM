package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/28/17:18
 * @Description:
 */
@Controller
public class HelloController {

    //  在服务器中斜线代表着绝对路径
    // 在服务器中斜线被解析之后就是localhost:8080+上下文路径：http://localhost:8080/SpringMVC/
    @RequestMapping("/")
    public String portal(){
        //将逻辑视图返回，进行视图转发，加上thymeleaf中配置的前缀和后缀
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}

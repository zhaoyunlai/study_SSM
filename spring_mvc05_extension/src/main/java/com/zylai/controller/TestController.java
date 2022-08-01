package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/11:15
 * @Description:
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello(){
        System.out.println("Controller-->testHello");
        System.out.println(1/0);
        return "success";
    }
}

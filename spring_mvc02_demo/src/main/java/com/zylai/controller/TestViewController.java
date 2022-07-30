package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/29/17:41
 * @Description:
 */
@Controller
public class TestViewController {
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleaf(){
        
        return "success";
    }
}

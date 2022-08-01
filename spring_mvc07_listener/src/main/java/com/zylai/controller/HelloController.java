package com.zylai.controller;

import com.zylai.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/17:57
 * @Description:
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
}

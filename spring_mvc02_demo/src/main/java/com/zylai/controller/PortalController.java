package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/28/19:19
 * @Description:
 */
@Controller
public class PortalController {

    @RequestMapping("/")
    public String portal(){
        return "index";
    }
}

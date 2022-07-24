package com.zylai.spring.controller;

import com.zylai.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/18:22
 * @Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }
}

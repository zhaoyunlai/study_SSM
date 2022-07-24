package com.zylai.spring.controller;

import com.zylai.spring.service.UserService;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/17:04
 * @Description:
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}

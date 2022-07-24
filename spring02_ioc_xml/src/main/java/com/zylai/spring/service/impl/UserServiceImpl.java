package com.zylai.spring.service.impl;

import com.zylai.spring.dao.UserDao;
import com.zylai.spring.service.UserService;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/17:04
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        System.out.println("进行保存-->Service");
        userDao.saveUser();
    }
}

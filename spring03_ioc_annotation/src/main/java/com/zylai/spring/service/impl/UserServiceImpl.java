package com.zylai.spring.service.impl;

import com.zylai.spring.dao.UserDao;
import com.zylai.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/18:22
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        System.out.println("保存信息-->service");
        userDao.saveUser();
    }
}

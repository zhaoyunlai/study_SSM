package com.zylai.spring.dao.impl;

import com.zylai.spring.dao.UserDao;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/17:05
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功-->DAO");
    }
}

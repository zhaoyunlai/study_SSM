package com.zylai.spring.dao.impl;

import com.zylai.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/18:23
 * @Description:
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功-->dao");
    }
}

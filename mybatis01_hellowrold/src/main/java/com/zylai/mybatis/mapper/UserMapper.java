package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.User;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/20/11:28
 * @Description:
 */
public interface UserMapper {
    //增
    int insertUser();

    //改
    void updateUser();

    //删
    void deleteUser();

    //根据id查
    User getUserById();

    //查询所有的用户信息
    List<User> getAllUser();
}

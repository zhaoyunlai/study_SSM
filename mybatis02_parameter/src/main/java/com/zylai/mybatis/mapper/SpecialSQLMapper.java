package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/15:25
 * @Description:
 */
public interface SpecialSQLMapper {

    //模糊查询用户名
    List<User> getUserByLike(@Param("keyword") String keyword);

    //批量删除
    void deleteMoreUser(@Param("ids") String ids);

    //动态设置表名，查询用户信息
    List<User> getUserList(@Param("tableName") String tableName);

    //添加用户信息并获取主键
    void insertUser(User user);
}

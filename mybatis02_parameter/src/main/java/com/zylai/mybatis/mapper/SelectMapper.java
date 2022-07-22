package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/11:56
 * @Description:
 */
public interface SelectMapper {
    /**
     * 若sql语句查询的结果为多条时，一定不能以实体类类型作为方法的返回值
     * 否则会抛出异常TooManyResultsException，因为底层调用sqlSession.selectOne方法
     *
     */
    //根据id查询用户信息
    User getUserById(@Param("id") Integer id);

    //查询所有的用户信息
    List<User> getAllUser();

    //查询用户的总数量
    Integer getCount();

    //根据id查询用户信息为map集合
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询的数据有多条时，并且把每条数据都转换为map集合
     * 两种方案：
     * 1.将mapper接口方法的返回值设置为泛型时map的list集合
     * List<Map<String,Object>>
     * 最终的结果：
     *{password=123456, gender=男, id=1, age=23, email=123@qq.com, username=admin1}
     * {password=123456, gender=男, id=2, age=23, email=123@qq.com, username=admin}
     * {password=123456, gender=男, id=4, age=23, email=123@qq.com, username=admin}
     * {password=123, gender=女, id=5, age=33, email=3232@163.com, username=xiaoming}
     * {password=123, gender=女, id=7, age=33, email=3232@163.com, username=xiaoming}
     * {password=123, id=8, username=jack}
     * {id=9}
     *
     *
     * 2.将每条数据转换的map集合放在一个大的map集合中，但是必须通过@MapKey注解
     * 将查询的某个字段的值作为大的map的键
     *  @MapKey("id")
     *  Map<String, Object>
     * 结果：
     * {
     * 1={password=123456, gender=男, id=1, age=23, email=123@qq.com, username=admin1},
     * 2={password=123456, gender=男, id=2, age=23, email=123@qq.com, username=admin},
     * 4={password=123456, gender=男, id=4, age=23, email=123@qq.com, username=admin},
     * 5={password=123, gender=女, id=5, age=33, email=3232@163.com, username=xiaoming},
     * 7={password=123, gender=女, id=7, age=33, email=3232@163.com, username=xiaoming},
     * 8={password=123, id=8, username=jack},
     * 9={id=9}
     * }
     */

    //查询所有的用户信息为map集合，这里需要使用list集合去存储map
    List<Map<String,Object>> getAllUserToMapList();

    //将查询出来的值放到map中，再把这些map放到一个大的map中，这个大的map的键通过注解指定为id
    @MapKey("id")
    Map<String,Object> getAllUserToMap();


}

package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/20/19:00
 * @Description:
 * Mybatis获取参数值的两种方式：#{} ${}
 * #{}的本质是占位符赋值，${}的本质是字符串拼接
 * 1、若mapper接口方法的参数为单个的字面量类型
 * 此时#{}和${}以任意内容获取参数值（不过一般使用参数名），一定注意${}的单引号问题
 *
 * 2、若mapper接口方法的参数为多个的字面量类型
 * 此时mybatis会将参数放在map集合中，以两种方式存储数据
 *  1）以arg0,arg1...为键，以参数为值
 *  2）以param1,param2,...为键，以参数为值
 * 因此，只需要通过#{}访问map的键来获取map的值。也可${}，注意单引号
 *
 * 下面省略说明${},都可以用${}实现，且注意加单引号
 * 3、若mapper接口方法的参数为一个map集合类型的参数
 * 只需要通过#{}访问map集合的键来获取map的值。
 *
 * 4、若mapper接口方法的参数为实体类类型的参数
 * 只需要通过#{}访问实体类中的属性名，就可以获取响应的属性值
 *什么是属性：是get方法去掉‘get’之后的字符串，首字母小写的名称。
 * 因为有时候没有声明成员变量，但是可以在get，set方法中去访问到对应的属性的
 *
 * 5、可以在mapper接口方法的参数上设置@param注解
 * 此时Mybatis会将这些参数放在map中，以两种方式进行存储
 *  1）以@Param注解的value属性值为键，以参数为值
 *  2）以param1，param2...为键，以参数为值
 *
 *  真正使用的就是两种情况：
 *  1.使用注解（包括了情况1,2,3,5  这些情况下建议都用注解）
 *  2.使用实体类对象，直接通过实体类属性获取值就可
 */
public interface UserMapper {
    //根据用户名查询用户信息
    User getUserByUsername(String username);

    //验证登录
    User checkLogin(String username,String password);

    //验证登录，map
    User checkLoginByMap(Map<String,Object> map);

    //添加用户信息
    void insertUser(User user);

    //使用注解，其中的value可以省略不写
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}

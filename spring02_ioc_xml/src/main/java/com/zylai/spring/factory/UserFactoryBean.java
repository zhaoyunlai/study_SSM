package com.zylai.spring.factory;

import com.zylai.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/24/16:50
 * @Description:
 * 三个方法：
 *  getObject():返回一个对象给IOC容器
 *  getObjectType():设置所提供对象的类型
 *  isSingleton():所提供的对象是否为单例
 *  当把FactoryBean的实现类配置为bean时，会将当前类中的getObject方法返回的对象交给IOC容器管理
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

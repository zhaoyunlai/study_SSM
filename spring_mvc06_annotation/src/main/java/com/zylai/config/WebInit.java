package com.zylai.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/14:48
 * @Description: 当前这个类用来代替web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //设置一个配置类代理spring的配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //设置一个配置类设置SpringMVC的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    //设置DispatcherServlet的url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //设置当前的过滤器
    @Override
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}

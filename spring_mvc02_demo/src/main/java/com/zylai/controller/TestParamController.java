package com.zylai.controller;

import com.zylai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/29/11:20
 * @Description:
 *
 * 获取请求参数的方式：
 * 1、通过servletAPI获取（用的不多）
 * 只需要在控制其方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象获取请求参数
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置设置好形参，其名字和请求参数的名字一致即可
 * 3、@RequestParam注解：将请求参数和控制器方法的形参绑定
 * 三个属性：value、required、defaultValue
 * value：设置和形参绑定的请求参数的名字
 * required：设置是否必须传输value设置的请求参数
 * 默认值为true，表示必须传输，否则报错400
 * defaultValue：当未传输value对应的请求参数时，为形参设置默认值，此时和required的值无关
 *
 * 4、@RequestHeader：将请求头信息和控制器方法的形参绑定
 * 5、@CookieValue：将cookie数据和控制器方法的形参绑定
 * 6、通过控制器方法的实体类类型的形参获取请求参数
 * 保证实体类中的属性的属性名和请求参数的名字一致，可以通过实体类类型的形参获取请求参数
 * 7、解决获取请求参数中的中文乱码问题
 * 在web.xml文件中配置过滤器
 */
@Controller
@RequestMapping("/param")
public class TestParamController {

    @RequestMapping("/servletapi")
//    直接在参数中写HttpServletRequest即可，DispatcherServlet会根据参数去匹配
    public String getParamByServletAPI(HttpServletRequest request){
//        由于DispatcherServlet已经获取了参数，所以在获取参数之后设置编码没有用处的
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/params")
    public String getParams(
            @RequestParam(value = "userName",required = false,defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId){


        System.out.println("username:"+username+",password:"+password);
        System.out.println("referer:"+referer+"\ncookie-jsessionId:"+jsessionId);
        return "success";
    }

    @RequestMapping("/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }


}

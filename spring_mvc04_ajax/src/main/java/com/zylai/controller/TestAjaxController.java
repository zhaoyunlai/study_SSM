package com.zylai.controller;

import com.zylai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/30/16:18
 * @Description:
 * 1、@RequestBody：将请求体中的内容和形参进行绑定
 * 2、使用@RequestBody注解将json格式的请求体中的参数转换为java对象
 * a>导入jackson的依赖
 * b>需要在SpringMVC配置文件中设置开启mvc的注解驱动
 * c>在控制器方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参，
 * 使用@RequestBody注解标识即可
 *
 * 3、@ResponseBody 就是把所标识的方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用@ResponseBody注解响应浏览器json格式的数据
 * 如何将java对象响应回去？如果直接response.getWriter().write，加入java对象，是返回的内存地址
 * 或者返回了一个toString方法的返回值，再者，如果将java类型的对象返回了，那么浏览器也不能处理java类型的数据
 *
 * a>导入jackson的依赖
 * b>需要在SpringMVC配置文件中设置开启mvc的注解驱动
 * c>将需要转换为json字符串的Java对象作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
 * 就可以将java对象直接转化为json字符串，并响应到浏览器
 *
 * 常用的java对象转化为json的结果：
 * 实体类-->json对象
 * map-->json对象
 * List-->json数组
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id:"+id);
        System.out.println("requestBody:"+requestBody);
        response.getWriter().write("hello.axios");
    }

    @RequestMapping("/test/requestbody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,requestBody");
    }

    @RequestMapping("/test/requestbody/map")
    public void testRequestBodyMap(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello,requestBody");
    }

    @RequestMapping("/test/responsebody")
    //这个注解就是把方法的返回值作为请求的返回体返回给浏览器
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    //非常方便，省略了将返回的java对象转换为json的过程，由框架完成
    @RequestMapping("/test/responsebody/json")
    @ResponseBody
    public User testResponseBodyJson(){
        User user = new User(1001,"admin","23232",20,"男");
        return user;
    }

    //响应map集合
    @RequestMapping("/test/responsebody/map")
    @ResponseBody
    public Map<String,Object> testResponseBodyMap(){
        User user1 = new User(1001,"admin1","23232",20,"男");
        User user2 = new User(1002,"admin2","23232",20,"男");
        User user3= new User(1003,"admin3","23232",20,"男");
        Map<String,Object> map = new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);
        return map;
    }


    //响应list集合
    @RequestMapping("/test/responsebody/list")
    @ResponseBody
    public List<Object> testResponseBodyList(){
        User user1 = new User(1001,"admin1","23232",20,"男");
        User user2 = new User(1002,"admin2","23232",20,"男");
        User user3= new User(1003,"admin3","23232",20,"男");
        List<Object> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}

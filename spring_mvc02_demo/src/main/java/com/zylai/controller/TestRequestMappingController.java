package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/28/19:19
 * @Description:
 *
 * 1、@RequestMapping注解标识的位置：
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 * 即，类上的路径加上方法上的路径
 * 2、@RequestMapping注解的value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的路径匹配value属性中的
 * 任何一个值，则当前请求就会被这个控制器方法进行处理
 * 3、method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式
 * 匹配method属性中的任何一种请求方式，则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的路径和value属性匹配，但是请求方式不匹配，
 * 则页面报错：HTTP状态 405 - 方法不允许
 *
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping，@PostMapping，@PutMapping，@DeleteMapping
 *在resetful章节中进行演示
 *
 * 4、params属性（了解）
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * 可以使用四种表达式：
 * "param"：表示当前所匹配请求的请求参数中必须携带param参数，不管他的值是啥
 * "!param"：表示当前所匹配请求的请求参数中一定不能携带param参数
 * "param=value"：表示当前所匹配请求的请求参数中必须携带param参数且值必须为value
 * "param!=value"：表示当前所匹配请求的请求参数中可以不携带param参数，若携带，值一定不等于value
 *
 * 5、headers属性（了解）
 * 作用：通过请求的请求头匹配请求，即浏览器发送的请求的请求头必须满足headers属性的设置
 * "header"：要求请求映射所匹配的请求必须携带header请求头信息
 * "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
 * "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
 * "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
 * 注意：若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，
 * 此时页面显示404错误，即资源未找到
 *
 * 6、SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的value属性中设置一些特殊字符
 * ?:任意的单个字符(不包括?和/)
 * *:表示0个或多个任意字符(不包括?和/)
 * **:表示任意层数的任意目录，注意使用方式只能将 ** 写在双斜线中，前后不能有任何的其他字符
 *
 * 7、使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest: /deleteUser/1
 * 需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 * 再通过@PathVariable注解，将占位符的值和控制器方法的形参进行绑定
 */

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {


    //此时控制器方法所匹配的请求的路径是 /test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET}
//            params = {"username","!password","gender=女","age!=18"}
            )
    public String hello(){
        return "success";
    }

    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{id}/{username}")
    public String testRest(@PathVariable(value = "id") Integer id,@PathVariable(value = "username")String username){

        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}

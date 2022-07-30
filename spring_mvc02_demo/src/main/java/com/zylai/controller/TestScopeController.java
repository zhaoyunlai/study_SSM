package com.zylai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/29/16:30
 * @Description:
 * 向域对象共享数据：
 * 底层中，不论用啥方法最终都是通过ModelAndView实现的
 * 1、通过ModelAndView向请求域共享数据
 * 用其Model功能向请求域中共享数据
 * 使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 下面这三种选一个常用就可，一般用Model多
 * 2、使用Model向请求域共享数据
 *   将Model作为控制器方法的形参就可
 * 3、使用ModelMap向请求域共享数据
 * 4、使用Map向请求域共享数据
 * 5、Model和ModelMap和Map的关系
 * 其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建的
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中设置数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println(model.getClass().getName());
        //org.springframework.validation.support.BindingAwareModelMap
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModel(ModelMap modelMap){
        System.out.println(modelMap.getClass().getName());
        //org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());
        //org.springframework.validation.support.BindingAwareModelMap
        map.put("testRequestScope","hello,Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,application");
        return "success";
    }


}

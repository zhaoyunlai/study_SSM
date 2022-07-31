package com.zylai.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/31/19:02
 * @Description:
 * ResponseEntity:可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * 如果不设置返回，返回值为void，那么会默认将请求地址作为逻辑视图
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
//获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
//获取服务器中文件的真实路径，其实就是直接把这个路径拼接到项目的后面
        String realPath = servletContext.getRealPath("img");
        //E:\code_workspace\study_SSM\spring_mvc04_ajax\target\spring_mvc04_ajax-1.0-SNAPSHOT\
        realPath = realPath + File.separator+"avatar.jpg";
//创建输入流
        InputStream is = new FileInputStream(realPath);
//创建字节数组
        byte[] bytes = new byte[is.available()];
//将流读到字节数组中
        is.read(bytes);
//创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
//设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
//设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
//创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
//关闭输入流
        is.close();
        return responseEntity;
    }
}

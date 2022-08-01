package com.zylai.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/31/19:02
 * @Description:
 * ResponseEntity:可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * 如果不设置返回，返回值为void，那么会默认将请求地址作为逻辑视图
 *
 * 这个地方就当做一个模板用就行
 *
 * 文件上传的要求：
 * 1、form表单的请求方式必须是post
 * 2、form表单必须设置属性enctype="multipart/form-data"，保证以二进制方式上传
 *
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
//创建字节数组，is.available()获取输入流所对应的文件的字节数。
//        对于流，可以设置响应的读取策略，可以适量多次读取
        byte[] bytes = new byte[is.available()];
//将流读到字节数组中
        is.read(bytes);
//创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
//设置要下载方式以及下载文件的名字，attachment：以附件的方式下载
        headers.add("Content-Disposition", "attachment;filename=avatar.jpg");
//设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
//创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
//关闭输入流
        is.close();
        return responseEntity;
    }


    @RequestMapping("/test/up")
    //注意：这里的MultipartFile不是由框架自动填充（就像request和session那样赋值），
    // 而是像普通参数一样从请求参数中获取
    public String testUp(@RequestParam("photo") MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String filename = photo.getOriginalFilename();
        //处理文件重名问题
        //获取上传的文件的后缀名
        String fileType = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID().toString() + fileType;
        System.out.println(filename);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();

        //获取当前工程下photo目录的真实路径
        String photoPath = servletContext.getRealPath("photo");

        //创建photoPath所对应的File对象
        File file = new File(photoPath);
        //判断file对应的目录是否存在
        if(!file.exists()){
            file.mkdir();
        }

        String finalPath = photoPath + File.separator + filename;
        //文件上传
        photo.transferTo(new File(finalPath));
        return "success";
    }


}

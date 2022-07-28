package com.zylai.spring.service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/18:52
 * @Description:
 */
public interface BookService {
    //买书
    void buyBook(Integer userId, Integer bookId);
}

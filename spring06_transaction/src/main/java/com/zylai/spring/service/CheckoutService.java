package com.zylai.spring.service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/28/11:10
 * @Description:
 */
public interface CheckoutService {

    void checkout(Integer userId,Integer[] bookIds);
}

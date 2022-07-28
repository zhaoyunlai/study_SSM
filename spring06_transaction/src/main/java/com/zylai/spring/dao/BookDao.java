package com.zylai.spring.dao;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/27/18:53
 * @Description:
 */
public interface BookDao {
    //根据图书的id查询价格
    Integer getPriceByBookId(Integer bookId);

    //更新图书库存
    void updateStock(Integer bookId);

    //更新用户余额
    void updateBalance(Integer userId, Integer price);
}

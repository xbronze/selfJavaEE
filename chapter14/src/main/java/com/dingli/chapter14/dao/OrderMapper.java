package com.dingli.chapter14.dao;

import com.dingli.chapter14.pojo.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author: xbronze
 * @date: 2024-09-10 08:54
 * @description: TODO
 */
public interface OrderMapper {

    /**
     * 根据订单编号查询订单记录
     * @param number
     * @return
     */
    @Select("select * from orders where number = #{number}")
    @Results(id = "orderMap", value = {
            @Result(id = true, property = "number", column = "number"),
            @Result(property = "id", column = "member_id"),
            @Result(property = "name", column = "product_name"),
            @Result(property = "count", column = "count"),
            @Result(property = "money", column = "money")
    })
    public Order getOrderByNum(String number);
}

package com.dingli.chapter14experiment.dao;

import com.dingli.chapter14experiment.pojo.Order;

/**
 * @author: xbronze
 * @date: 2024-11-20 15:39
 * @description: TODO
 */
public interface OrderMapper {

    public Order getOrderByNum(String number);
}

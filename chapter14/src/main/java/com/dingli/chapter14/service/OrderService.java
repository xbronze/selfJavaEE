package com.dingli.chapter14.service;

import com.dingli.chapter14.pojo.Order;

/**
 * @author: xbronze
 * @date: 2024-09-10 09:24
 * @description: TODO
 */
public interface OrderService {

    public Order queryOrderByNum(String number);

}
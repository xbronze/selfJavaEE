package com.dingli.chapter14.service.impl;

import com.dingli.chapter14.dao.OrderMapper;
import com.dingli.chapter14.pojo.Order;
import com.dingli.chapter14.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: xbronze
 * @date: 2024-09-10 09:25
 * @description: TODO
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderByNum(String number) {
        return orderMapper.getOrderByNum(number);
    }
}

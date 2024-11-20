package com.dingli.chapter14experiment.service.impl;

import com.dingli.chapter14experiment.dao.OrderMapper;
import com.dingli.chapter14experiment.pojo.Order;
import com.dingli.chapter14experiment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: xbronze
 * @date: 2024-11-20 15:38
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

package com.dingli.chapter5experiment.service.impl;

import com.dingli.chapter5experiment.service.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xbronze
 * @date: 2024-09-30 15:58
 * @description: TODO
 */
@Component
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT)
    @Override
    public void createOrder() {
        int result = jdbcTemplate.update("insert into order_record (username, product_name, num) values (?,?,?)",
                "李四", "电视机", 1);
        if (result > 0) {
            System.out.println("新增订单成功");
        }

        // 模拟程序运行中的异常输出，测试事务管是否回滚
        if (2 > 1) {
            throw new RuntimeException("自定义异常输出");
        }

        int result2 = jdbcTemplate.update("update product set num = num - ? where product_name = ?",
                1, "电视机");
        if (result2 > 0) {
            System.out.println("库存更新成功");
        }
    }
}

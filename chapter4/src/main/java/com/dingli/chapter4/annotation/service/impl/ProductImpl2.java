package com.dingli.chapter4.annotation.service.impl;

import com.dingli.chapter4.annotation.service.IProduct2;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-03 11:32
 * @description: TODO
 */
@Component
public class ProductImpl2 implements IProduct2 {
    @Override
    public void insert() {
        System.out.println("添加信息......");
    }

    @Override
    public void delete() {
        System.out.println("删除信息......");
        throw new RuntimeException("数据异常！");
    }
}

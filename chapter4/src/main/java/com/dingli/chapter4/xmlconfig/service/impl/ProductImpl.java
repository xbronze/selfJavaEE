package com.dingli.chapter4.xmlconfig.service.impl;

import com.dingli.chapter4.xmlconfig.service.IProduct;

/**
 * @author: xbronze
 * @date: 2024-09-03 11:32
 * @description: TODO
 */
public class ProductImpl implements IProduct {
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

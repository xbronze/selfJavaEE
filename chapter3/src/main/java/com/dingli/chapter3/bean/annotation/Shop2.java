package com.dingli.chapter3.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:29
 * @description: TODO
 */
@Component
public class Shop2 {

    // 店铺名
    @Value("小小奶茶店annotation")
    private String shopName;
    // 奶茶信息
    @Autowired
    private BubbleTea2 bubbleTea;


    //定义方法输出订单信息
    public void showOrderInfo() {
        System.out.println("订单信息：" + shopName + " " + bubbleTea.getDrinkName() + " "
                + bubbleTea.getSize() + " " + bubbleTea.getIce() + " " + bubbleTea.getSugar());
    }

}

package com.dingli.chapter3.bean.constructor;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:29
 * @description: TODO
 */
public class Shop1 {

    // 店铺名
    private String shopName;
    // 奶茶信息
    private BubbleTea1 bubbleTea1;

    public Shop1(String shopName, BubbleTea1 bubbleTea1) {
        this.shopName = shopName;
        this.bubbleTea1 = bubbleTea1;
    }

    //定义方法输出订单信息
    public void showOrderInfo() {
        System.out.println("订单信息：" + shopName + " " + bubbleTea1.getDrinkName() + " "
                + bubbleTea1.getSize() + " " + bubbleTea1.getIce() + " " + bubbleTea1.getSugar());
    }

}

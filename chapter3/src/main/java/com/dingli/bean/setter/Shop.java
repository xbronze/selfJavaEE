package com.dingli.bean.setter;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:29
 * @description: TODO
 */
public class Shop {

    // 店铺名
    private String shopName;
    // 奶茶信息
    private BubbleTea bubbleTea;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BubbleTea getBubbleTea() {
        return bubbleTea;
    }

    public void setBubbleTea(BubbleTea bubbleTea) {
        this.bubbleTea = bubbleTea;
    }

    //定义方法输出订单信息
    public void showOrderInfo() {
        System.out.println("订单信息：" + shopName + " " + bubbleTea.getDrinkName() + " "
                + bubbleTea.getSize() + " " + bubbleTea.getIce() + " " + bubbleTea.getSugar());
    }

}

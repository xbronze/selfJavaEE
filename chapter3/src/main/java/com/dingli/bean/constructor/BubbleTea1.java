package com.dingli.bean.constructor;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:26
 * @description: TODO
 */
public class BubbleTea1 {

    // 奶茶名
    private String drinkName;
    // 奶茶规格
    private String size;
    // 温度
    private String ice;
    // 甜度
    private String sugar;

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    // 构造方法注入
    public BubbleTea1(String drinkName, String size, String ice, String sugar) {
        this.drinkName = drinkName;
        this.size = size;
        this.ice = ice;
        this.sugar = sugar;
    }
}

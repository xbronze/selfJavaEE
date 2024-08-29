package com.dingli.bean.setter;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:26
 * @description: TODO
 */
public class BubbleTea {

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
}

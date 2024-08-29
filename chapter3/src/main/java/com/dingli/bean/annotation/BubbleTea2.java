package com.dingli.bean.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:26
 * @description: TODO
 */
@Component
public class BubbleTea2 {

    //定义属性，并使用@Value注解注入属性值
    @Value("红豆奶茶")
    private String drinkName;
    @Value("大杯")
    private String size;
    @Value("去冰")
    private String ice;
    @Value("3分糖")
    private String sugar;

    public String getDrinkName() {
        return drinkName;
    }

    public String getSize() {
        return size;
    }

    public String getIce() {
        return ice;
    }

    public String getSugar() {
        return sugar;
    }

}

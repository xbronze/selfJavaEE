package com.dingli.bean.setter;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:43
 * @description: setter方法注入
 */
public class SetterTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("setter.xml");
        Shop shop = context.getBean("shop", Shop.class);
        shop.showOrderInfo();
        ((AbstractApplicationContext)context).close();
    }
}

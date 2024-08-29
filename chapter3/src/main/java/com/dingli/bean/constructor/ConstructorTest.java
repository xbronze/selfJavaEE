package com.dingli.bean.constructor;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-08-29 14:55
 * @description: 构造方法注入
 */
public class ConstructorTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructor.xml");
        Shop1 shop1 = context.getBean("shop1", Shop1.class);
        shop1.showOrderInfo();
        ((AbstractApplicationContext)context).close();
    }
}

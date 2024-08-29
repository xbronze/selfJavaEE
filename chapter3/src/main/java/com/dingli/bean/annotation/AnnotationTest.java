package com.dingli.bean.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-08-29 16:22
 * @description: 注解方式注入
 */
public class AnnotationTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        Shop2 shop2 = context.getBean("shop2", Shop2.class);
        shop2.showOrderInfo();
        ((AbstractApplicationContext) context).close();
    }
}

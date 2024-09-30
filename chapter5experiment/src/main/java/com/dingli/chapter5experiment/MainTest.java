package com.dingli.chapter5experiment;

import com.dingli.chapter5experiment.service.OrderManageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("transactionAnno.xml");
        OrderManageService orderManageService = context.getBean("orderManageServiceImpl", OrderManageService.class);
        orderManageService.createOrder();
        ((AbstractApplicationContext) context).close();
    }
}
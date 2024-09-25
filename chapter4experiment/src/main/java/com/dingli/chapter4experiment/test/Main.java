package com.dingli.chapter4experiment.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        userService.insert();
        userService.update();
        ((AbstractApplicationContext) context).close();
    }
}
package com.dingli.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 从Spring容器中获取指定Bean对象
        User user = context.getBean("user", User.class);
        user.setName("china");
        // 使用已经初始化的对象
        user.sayHello();
    }
}
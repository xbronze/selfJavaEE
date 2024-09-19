package com.dingli.chapter3experiment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: xbronze
 * @date: 2024-09-14 08:19
 * @description: TODO
 */
@Component
@Scope("singleton")
public class Student {

    @Value("20230102001")
    private String number;

    @Value("1234567")
    private String password;

    @Value("学生")
    private String identity;

    @Autowired
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", school=" + school +
                '}';
    }

    // 初始化后节点的监控方法
    @PostConstruct
    public void init() {
        System.out.println("Student 对象初始化");
    }

    // 销毁前节点的监控方法
    @PreDestroy
    public void destroy() {
        System.out.println("Student 对象销毁");
    }
}

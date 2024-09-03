package com.dingli.chapter3.bean.lifecycle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: xbronze
 * @date: 2024-08-29 16:56
 * @description: 通过@PostConstruct和@PreDestroy注解来标注监控方法
 */
@Component
public class LifecycleAnnotation {

    @Value("生命周期测试-注解方式")
    private String content;

    @PostConstruct
    public void init() {
        System.out.println("Bean初始化后，调用init()方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean销毁前，调用destroy()方法");
    }

    public void print() {
        System.out.println("输出属性值：" + content);
    }

}

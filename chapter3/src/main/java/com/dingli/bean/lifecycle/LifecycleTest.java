package com.dingli.bean.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-08-29 16:39
 * @description: TODO
 */
public class LifecycleTest {

    @Test
    public void test() {
        //加载lifecycle.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
        //获取Bean实例lifecycle
        Lifecycle lifecycle = (Lifecycle)context.getBean("lifecycle");
        lifecycle.print();
        //关闭容器
        ((AbstractApplicationContext) context).close();

    }
}

package com.dingli.bean.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-08-29 17:10
 * @description: TODO
 */
public class LifecycleAnnotationTest {

    @Test
    public void test() {
        //加载lifecycle.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        //获取Bean实例lifecycle
        LifecycleAnnotation lifecycleAnnotation = context.getBean("lifecycleAnnotation", LifecycleAnnotation.class);
        lifecycleAnnotation.print();
        //关闭容器
        ((AbstractApplicationContext) context).close();
    }
}

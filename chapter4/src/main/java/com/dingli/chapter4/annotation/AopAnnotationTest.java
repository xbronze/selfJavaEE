package com.dingli.chapter4.annotation;

import com.dingli.chapter4.annotation.service.IProduct2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-09-03 16:07
 * @description: 基于注解实现的AOP
 */
public class AopAnnotationTest {

    public static void main(String[] args) {
        //加载aopAnnotation.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("aopAnnotation.xml");
        //获取Bean实例
        IProduct2 product2 = context.getBean("productImpl2", IProduct2.class);
        product2.insert();
        System.out.println("===================================================");
        product2.delete();
        // 关闭容器
        ((AbstractApplicationContext) context).close();
    }
}

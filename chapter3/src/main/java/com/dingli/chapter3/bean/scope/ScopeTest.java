package com.dingli.chapter3.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-09-18 17:58
 * @description: TODO
 */
public class ScopeTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("scope.xml");
        Scope scope = context.getBean("scope", Scope.class);
        System.out.println(scope);
        Scope scope2 = context.getBean("scope", Scope.class);
        System.out.println(scope2);

        // 两次getBean获取Scope初始化对象，是不同的对象，每次getBean都会重新初始化一次
    }
}

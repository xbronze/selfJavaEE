package com.dingli.chapter2;

/**
 * @author: xbronze
 * @date: 2024-08-29 11:35
 * @description: TODO
 */
public class User {

    private String name;

    public void sayHello() {
        System.out.println("hello world Spring！" + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

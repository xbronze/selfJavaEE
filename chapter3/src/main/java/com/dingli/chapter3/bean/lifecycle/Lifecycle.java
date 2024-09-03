package com.dingli.chapter3.bean.lifecycle;

/**
 * @author: xbronze
 * @date: 2024-08-29 16:35
 * @description: Bean的生命周期
 */
public class Lifecycle {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public void init() {
        System.out.println("Bean初始化后，调用init()方法");
    }

    public void destroy() {
        System.out.println("Bean销毁前，调用destroy()方法");
    }

    public void print() {
        System.out.println("输出属性值：" + content);
    }
}

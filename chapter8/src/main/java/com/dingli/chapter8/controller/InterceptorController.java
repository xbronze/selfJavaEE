package com.dingli.chapter8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xbronze
 * @date: 2024-09-21 13:15
 * @description: TODO
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    // 设置控制器方法的映射路径
    @RequestMapping("/submit")
    public String submit() {
        return "submit1";
    }

    @RequestMapping("/check")
    public String check(Integer age, String gender) {
        if (age < 0 || age > 100 || !"男、女".contains(gender)) {
            throw new RuntimeException("年龄或性别输入错误");
        }
        return "success";
    }
}

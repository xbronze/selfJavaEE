package com.dingli.chapter8.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: xbronze
 * @date: 2024-09-20 20:39
 * @description: TODO
 */
@ControllerAdvice
public class ExceptionHandler2 {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        // 创建 ModelAndView 类对象
        ModelAndView modelAndView = new ModelAndView();
        // 在ModelAndView类对象中添加名为exp的数据
        modelAndView.addObject("exp", ex);
        // 在ModelAndView类对象中设置视图名称为 defaultExp
        modelAndView.setViewName("defaultExp");
        return modelAndView;
    }

}

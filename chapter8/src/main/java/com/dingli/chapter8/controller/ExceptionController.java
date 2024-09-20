package com.dingli.chapter8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author: xbronze
 * @date: 2024-09-20 19:59
 * @description: TODO
 */
@Controller
public class ExceptionController {

    @RequestMapping("/showArithmetic")
    public void showArithmetic() {
        // 模拟算数异常
        int i = 1/0;
    }

    @RequestMapping("/showIOException")
    public void showIOException() throws FileNotFoundException {
        // 模拟IO异常
        FileInputStream in = new FileInputStream("Java.xml");
    }

    @RequestMapping("/showCustomException")
    public void showCustomException() {
        // 抛出自定义异常
        throw new CustomException("自定义异常");
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exp", ex);
//        modelAndView.setViewName("defaultExp");
//        return modelAndView;
//    }
}

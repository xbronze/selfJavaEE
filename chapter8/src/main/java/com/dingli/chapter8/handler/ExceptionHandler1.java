package com.dingli.chapter8.handler;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: xbronze
 * @date: 2024-09-20 20:20
 * @description: TODO
 */
public class ExceptionHandler1 implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 创建 ModelAndView 类对象
        ModelAndView modelAndView = new ModelAndView();
        // 在ModelAndView类对象中添加名为exp的数据
        modelAndView.addObject("exp", ex);
        // 在ModelAndView类对象中设置视图名称为 defaultExp
        modelAndView.setViewName("defaultExp");
        return modelAndView;
    }
}

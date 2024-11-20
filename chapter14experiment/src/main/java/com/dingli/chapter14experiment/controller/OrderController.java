package com.dingli.chapter14experiment.controller;

import com.dingli.chapter14experiment.pojo.Order;
import com.dingli.chapter14experiment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: xbronze
 * @date: 2024-11-20 15:42
 * @description: TODO
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;  // 定义并自动装配OrderService对象

    @RequestMapping("/queryOrderByNum")  // 设置控制器方法的映射路径
    public ModelAndView queryOrderByNum(String number) {
        Order order = orderService.queryOrderByNum(number);
        // 创建ModelAndView类对象
        ModelAndView modelAndView = new ModelAndView();
        // 在ModelAndView类对象中添加名称为order的数据
        modelAndView.addObject("order", order);
        // 在ModelAndView类对象中设置视图名称为queryOrder
        modelAndView.setViewName("queryOrder");
        return modelAndView;
    }

}

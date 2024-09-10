package com.dingli.chapter14.controller;

import com.dingli.chapter14.pojo.Order;
import com.dingli.chapter14.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: xbronze
 * @date: 2024-09-10 09:27
 * @description: TODO
 */

@Controller  // 设置当前类为控制器类
@RequestMapping("/order") // 设置控制器类的映射路径
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

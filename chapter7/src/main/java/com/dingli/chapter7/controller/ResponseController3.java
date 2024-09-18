package com.dingli.chapter7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/response3")
public class ResponseController3 {

    @RequestMapping("/submit")
    public String submit() {
        return "submit2";
    }

    @RequestMapping("/returnPage")
    public ModelAndView returnPage(Questionary questionary) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questionary", questionary);
        modelAndView.setViewName("success_data2");
        return modelAndView;
    }
}

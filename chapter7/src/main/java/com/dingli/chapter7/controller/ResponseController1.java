package com.dingli.chapter7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response1")
public class ResponseController1 {

    @RequestMapping("/returnData")
    @ResponseBody
    public Questionary returnData() {
        Questionary questionary = new Questionary();
        questionary.setAge(23);
        questionary.setGender("其他");
        questionary.setHobbies(new String[]{"阅读","运动","电影"});
        return questionary;
    }
}

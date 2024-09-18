package com.dingli.chapter7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller                    //设置当前类为控制器类
@RequestMapping(value="/bind3")			//设置控制器类的映射路径
public class BindController3 {

    @RequestMapping(value="/submit")		//设置控制器方法的映射路径
    public String submit() {
        return "submit_json";		//跳转到submit_json.jsp
    }

    //JSON数据绑定
    @RequestMapping(value="/getParams")
    public void getParams(@RequestBody Questionary questionary) {
        System.out.println("年龄:" + questionary.getAge());
        System.out.println("性别:" + questionary.getGender());
        String s = "";
        for (String hobby:questionary.getHobbies()) {
            s = s + hobby + " ";
        }
        System.out.print("爱好:" + s);
    }
}

package com.dingli.chapter6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: xbronze
 * @date: 2024-09-09 09:34
 * @description: TODO
 */
@Controller
@RequestMapping("/user")
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    // 设置控制器方法的映射路径，并指定请求方式
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}

package com.dingli.chapter7experiment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: xbronze
 * @date: 2024-09-27 18:27
 * @description: TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //设置控制器方法的映射路径
    @RequestMapping(value = "/loginCheck")
    public String logincheck(User user, HttpServletRequest request) {
        //验证用户信息
        if ("1001".equals(user.getNumber()) && "123456".equals(user.getPassword())
                && "学生".equals(user.getIdentity())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);    //将用户信息放到session域中
            return "redirect:/user/main";        //重定向“/user/main”
        } else {
            //设置用户信息错误提示
            request.setAttribute("msg", "用户信息错误");
            return "login";
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();        //设置session失效
        return "forward:/user/login";            //转发“/user/login”
    }

}

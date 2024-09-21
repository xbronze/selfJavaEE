package com.dingli.chapter8experiment.controller;

import com.dingli.chapter8experiment.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-21 14:13
 * @description: User控制类
 */
@Controller   // 设置当前类为控制器类
@RequestMapping("/system")  // 设置控制器类的映射路径
public class SystemController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(User user, HttpServletRequest request) {
        // 定义SQL查询语句，实现根据用户信息查询users表中的用户记录
        String sql = "select * from student where number = ? and password = ? and identity = ?";
        // 定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {user.getNumber(), user.getPassword(), user.getIdentity()};
        // 创建一个BeanPropertyRowMapper对象
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        // 执行SQL查询
        List<User> user_db = jdbcTemplate.query(sql, rowMapper, obj);
        // 判断用户是否为空
        if (!user_db.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);  // 将用户信息保存到session中
            return "redirect:/system/main";  // 重定向跳转到主页面 main1.jsp
        } else {
            request.setAttribute("msg", "用户信息错误");
            return "login";  // 跳转到登录页面login1.jsp
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();  // 设置session失效
        return "redirect:/system/login";  // 重定向跳转到登录页面login1.jsp
    }

    @RequestMapping("/query")
    public String query() {
        return "query";  // 跳转到查询页面query.jsp
    }

    @RequestMapping("/add")
    public String add() {
        return "add";  // 跳转到查询页面add.jsp
    }
}

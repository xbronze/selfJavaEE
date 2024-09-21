package com.dingli.chapter8experiment.interceptor;

import com.dingli.chapter8experiment.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: xbronze
 * @date: 2024-09-21 14:27
 * @description: 自定义拦截器
 */
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null) {
            throw new Exception("未登录，无权限访问系统主页");
        }
        if ("学生".equals(loginUser.getIdentity()) && "/system/add".equals(request.getServletPath())) {
            throw new Exception("学生无权限执行添加操作");
        }
        return true;
    }

}

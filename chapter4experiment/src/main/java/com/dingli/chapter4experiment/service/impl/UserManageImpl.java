package com.dingli.chapter4experiment.service.impl;

import com.dingli.chapter4experiment.service.UserManage;
import org.springframework.stereotype.Component;

/**
*@author: xbronze
*@date: 2024-09-25 20:55
*@description: TODO
*/
@Component
public class UserManageImpl implements UserManage {

    static String number;
    static String password;
    static String identity;

    public String getNumber() {
        return this.number;
    }

    public String getIdentity() {
        return this.identity;
    }

    @Override
    public void login(String number, String password, String identity) {
        if ("1001".equals(number) && "123456".equals(password) && "学生".equals(identity)) {
            System.out.println(number + " 用户登录成功");
            this.number = number;
            this.password = password;
            this.identity = identity;
        } else {
            throw new RuntimeException("账号或密码错误");
        }
    }

    @Override
    public void quit() {
        System.out.println("用户退出登录");
    }
}

package com.dingli.chapter8experiment.pojo;

import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-21 14:17
 * @description: TODO
 */
@Component
public class User {

    private String  number;
    private String  password;
    private String identity;


    public void setNumber(String number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getIdentity() {
        return identity;
    }
}

package com.dingli.chapter3experiment;

/**
 * @author: xbronze
 * @date: 2024-09-14 08:13
 * @description: TODO
 */
public class Student {

    private String number;
    private String password;
    private String identity;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}

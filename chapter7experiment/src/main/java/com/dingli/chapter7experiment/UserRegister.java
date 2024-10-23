package com.dingli.chapter7experiment;

import java.util.Arrays;

/**
 * @author: xbronze
 * @date: 2024-10-23 08:47
 * @description: TODO
 */
public class UserRegister {

    private String number;
    private String password;
    private String identity;

    private Boolean graduate; // 是否毕业
    private String[] hobbies;

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

    public Boolean getGraduate() {
        return graduate;
    }

    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", graduate=" + graduate +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }
}

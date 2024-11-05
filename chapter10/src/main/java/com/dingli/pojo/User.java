package com.dingli.pojo;

/**
 * @author: xbronze
 * @date: 2024-11-05 08:55
 * @description: TODO
 */
public class User {

    private Integer userId;
    private String userName;
    private Integer userLevel;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }
}

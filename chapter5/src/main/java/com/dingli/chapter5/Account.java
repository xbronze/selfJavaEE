package com.dingli.chapter5;

/**
 * @author: xbronze
 * @date: 2024-09-05 14:40
 * @description: TODO
 */
public class Account {

    private Integer id;						//账户id
    private String userName;					//账户名称
    private Double balance;					//账户余额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

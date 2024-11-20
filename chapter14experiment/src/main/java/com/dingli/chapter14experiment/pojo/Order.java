package com.dingli.chapter14experiment.pojo;

/**
 * @author: xbronze
 * @date: 2024-11-20 15:35
 * @description: TODO
 */
public class Order {

    private String number;
    private String id;
    private String name;
    private Integer count;
    private Double money;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}

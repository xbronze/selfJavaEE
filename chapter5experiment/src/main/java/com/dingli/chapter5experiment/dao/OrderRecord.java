package com.dingli.chapter5experiment.dao;

/**
 * @author: xbronze
 * @date: 2024-09-30 15:52
 * @description: 订单
 */
public class OrderRecord {

    private int id;
    private String username;
    private String product_name;
    private int num;

    public OrderRecord(int id, String username, String product_name, int num) {
        this.id = id;
        this.username = username;
        this.product_name = product_name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

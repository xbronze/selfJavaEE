package com.dingli.chapter5.service;

/**
 * @author: xbronze
 * @date: 2024-09-06 10:08
 * @description: 转账业务
 */
public interface ITransaction {

    //定义转账方法
    public void transfer(Integer outAccount, Integer inAccount, Double money);

}

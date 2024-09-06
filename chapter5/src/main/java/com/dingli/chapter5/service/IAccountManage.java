package com.dingli.chapter5.service;

import com.dingli.chapter5.Account;

/**
*@author: xbronze
*@date: 2024-09-05 14:41
*@description: TODO
*/
public interface IAccountManage {

    public void addAccount(Account account);		//插入账户记录
    public void updateAccount(Account account);		//更新账户记录
    public void queryAccountById(Integer id);		//查询单个账户记录
    public void queryAllAccount();			//查询所有账户记录
    public void deleteAccount(Integer id);			//删除账户记录


}

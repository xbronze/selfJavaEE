package com.dingli.chapter5;

import com.dingli.chapter5.service.IAccountManage;
import com.dingli.chapter5.service.ITransaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-09-06 10:09
 * @description: 基于XML的声明式事务管理
 */
public class TransactionXmlTest {

    public static void main(String[] args) {
        //加载transactionXml.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");
        //获取Bean实例accountManage
        IAccountManage accountManage = context.getBean("accountManage", IAccountManage.class);
        //获取Bean实例transaction
        ITransaction transaction = context.getBean("transaction", ITransaction.class);
        //调用方法执行查询所有的账户记录和转账操作
        accountManage.queryAllAccount();
        transaction.transfer(1, 2, 100.0);
        accountManage.queryAllAccount();
        try {
            transaction.transfer(1, 3, 100.0);
        } catch(RuntimeException e) {
            System.out.println("异常信息：" + e.getMessage());
        }
        accountManage.queryAllAccount();
        //关闭容器
        ((AbstractApplicationContext) context).close();

    }
}

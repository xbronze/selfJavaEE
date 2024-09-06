package com.dingli.chapter5;

import com.dingli.chapter5.service.IAccountManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        //创建表
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        String sql = "create table if not exists accounts (id int, userName varchar(50), balance double)";
//        jdbcTemplate.execute(sql);
//        System.out.println("数据库accounts创建成功");
        IAccountManage accountManage = context.getBean("accountManage", IAccountManage.class);
        // 新增数据
//        Account account = new Account();
//        account.setId(1);
//        account.setUserName("张三");
//        account.setBalance(2000.0);
//        accountManage.addAccount(account);


        //删除账户id为10010011的账户记录
//        accountManage.deleteAccount(1);

        //插入一条账户记录
//        Account account2 = new Account();
//        account2.setId(10010013);
//        account2.setUserName("赵六");
//        account2.setBalance(8000.0);
//        accountManage.addAccount(account2);

        //查询所有的账户记录
        accountManage.queryAllAccount();

        // 关闭容器
        ((AbstractApplicationContext) context).close();
    }
}
package com.dingli.chapter5.service.impl;

import com.dingli.chapter5.Account;
import com.dingli.chapter5.service.IAccountManage;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author: xbronze
 * @date: 2024-09-05 14:41
 * @description: TODO
 */
public class AccountManageImpl implements IAccountManage {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAccount(Account account) {
        //定义SQL插入语句，实现插入一条账户记录
        String sql = "insert into accounts(id,userName,balance) value(?,?,?)";
        //定义数组来存放SQL语句中的参数
        Object[] obj = new Object[] {
                account.getId(),
                account.getUserName(),
                account.getBalance()
        };
        //执行SQL插入语句，返回执行添加操作的记录条数
        int num = jdbcTemplate.update(sql, obj);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条账户记录");
            System.out.println(account);
        }
        else
            System.out.println("执行插入账户记录失败");

    }

    @Override
    public void updateAccount(Account account) {
        //定义SQL更新语句，实现根据账户id更新余额
        String sql = "update accounts set balance=? where id = ?";
        //定义数组来存放SQL语句中的参数
        Object[] params = new Object[] {account.getBalance(), account.getId()};
        //执行SQL更新语句，返回执行更新操作的记录条数
        int num = jdbcTemplate.update(sql, params);
        if (num > 0) {
            System.out.println("成功更新了" + num + "条账户记录");
        }
        else
            System.out.println("执行更新账户记录失败");

    }

    @Override
    public void queryAccountById(Integer id) {
        //定义SQL查询语句，实现根据账户id查询账户记录
        String sql = "select * from accounts where id = ?";
        //创建一个BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper;
        rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行SQL查询语句，并通过rowMapper返回Account类对象
        Account account = jdbcTemplate.queryForObject(sql, rowMapper, id);
        System.out.println("成功查询了1个账户记录");
        System.out.println(account);

    }

    @Override
    public void queryAllAccount() {
        //定义SQL查询语句，实现查询所有的账户记录
        String sql = "select * from accounts";
        //创建一个BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper;
        rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //执行SQL查询语句，并通过rowMapper返回存放Account类对象的List集合
        List<Account> accounts = jdbcTemplate.query(sql, rowMapper);
        System.out.println("成功查询了所有的账户记录");
        for (Account account:accounts) {		//循环输出每个账户记录
            System.out.println(account);
        }

    }

    @Override
    public void deleteAccount(Integer id) {
        //定义SQL删除语句，实现根据id删除账户记录
        String sql = "delete from accounts where id = ? ";
        //执行SQL删除语句，返回执行删除操作的记录条数
        int num = jdbcTemplate.update(sql, id);
        if (num > 0)
            System.out.println("成功删除了" + num + "条账户记录");
        else
            System.out.println("执行删除账户记录失败");

    }

}

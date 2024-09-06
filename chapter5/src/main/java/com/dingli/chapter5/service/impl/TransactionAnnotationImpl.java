package com.dingli.chapter5.service.impl;

import com.dingli.chapter5.service.ITransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xbronze
 * @date: 2024-09-06 10:09
 * @description: 转账业务实现（注解方式实现事务管理）
 */
@Component
public class TransactionAnnotationImpl implements ITransaction {

    //定义jdbcTemplate属性及其setXxx()方法
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param outAccount 汇款账户
     * @param inAccount 收款账户
     * @param money 转账金额
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.DEFAULT)
    @Override
    public void transfer(Integer outAccount, Integer inAccount, Double money) {
        //汇款时，汇款账户余额=现有余额−转账金额
        int outNum = jdbcTemplate.update("update accounts set balance = balance-?  where id = ?", money, outAccount);
        if (outNum > 0) {
            System.out.println(outAccount + "汇款成功");
        } else {
            throw new RuntimeException(outAccount + "汇款失败");
        }
        //收款时，收款账户余额=现有余额+转账金额
        int inNum = jdbcTemplate.update("update accounts set balance = balance +? where id = ?", money, inAccount);
        if (inNum > 0) {
            System.out.println(inAccount + "收款成功");
        } else {
            throw new RuntimeException(inAccount + "收款失败");
        }
    }

}

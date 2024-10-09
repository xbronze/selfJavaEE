package com.dingli.chapter5;

import java.sql.*;

/**
 * @author: xbronze
 * @date: 2024-09-30 10:51
 * @description: java传统方式连接并访问mysql数据库
 */
public class TraditionMethod {


    /**
     * 传统JDBC访问数据库的步骤：
     *
     * 加载驱动
     * 创建数据库连接
     * 创建sql语句并执行
     * 处理执行结果
     * 释放资源
     */

    public static void main(String[] args) {
        // 数据库连接URL
        String url = "jdbc:mysql://localhost:3306/db_spring";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "123456";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 加载并注册JDBC驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            connection = DriverManager.getConnection(url, username, password);
            // 创建Statement对象来执行SQL语句
            statement = connection.createStatement();
            // 执行查询并获取结果
            resultSet = statement.executeQuery("select * from accounts");
            // 遍历结果集
            while ((resultSet.next())) {
                System.out.println("id:" + resultSet.getInt("id")
                        + " userName:" + resultSet.getString("userName")
                            + " balance:" + resultSet.getString("balance"));
            }

            // 关闭结果集，statement和连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    resultSet.close();
                    statement.close();
                } catch (Exception e) {

                }
            }
        }
    }


    // 以上只是执行了个简单的查询，如果再加上事务的话就更复杂了，因为要回滚什么的。
    // 而很不幸的是你每次执行数据库操作都要把上面的步骤来一次，而你真正需要处理的只有第三第四步，其他的都是重复的工作。
}

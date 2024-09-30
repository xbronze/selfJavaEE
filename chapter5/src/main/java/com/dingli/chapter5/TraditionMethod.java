package com.dingli.chapter5;

import java.sql.*;

/**
 * @author: xbronze
 * @date: 2024-09-30 10:51
 * @description: java传统方式连接并访问mysql数据库
 */
public class TraditionMethod {

    public static void main(String[] args) {
        // 数据库连接URL
        String url = "jdbc:mysql://localhost:3306/db_spring";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "123456";

        try {
            // 加载并注册JDBC驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            Connection connection = DriverManager.getConnection(url, username, password);
            // 创建Statement对象来执行SQL语句
            Statement statement = connection.createStatement();
            // 执行查询并获取结果
            ResultSet resultSet = statement.executeQuery("select * from accounts");
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
        }
    }
}

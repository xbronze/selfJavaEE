package com.dingli;

import com.dingli.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 读取核心配置文件mybatis-config.xml
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件创建SqlSessionFactory对象
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过SqlSessionFactory创建SqlSession对象
        SqlSession sqlSession = ssf.openSession(true);
        // 执行映射的SQL查询语句，查询所有的用户记录，并返回存放User类对象的List集合
        List<User> users = sqlSession.selectList("queryAllUser");
        System.out.println("查询所有的用户记录：");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
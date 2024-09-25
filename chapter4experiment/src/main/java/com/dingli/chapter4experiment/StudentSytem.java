package com.dingli.chapter4experiment;

import com.dingli.chapter4experiment.service.ScoreManage;
import com.dingli.chapter4experiment.service.StudentManage;
import com.dingli.chapter4experiment.service.UserManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xbronze
 * @date: 2024-09-25 21:15
 * @description: TODO
 */
public class StudentSytem {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("student_system.xml");
        UserManage userManage = context.getBean("userManageImpl", UserManage.class);
        StudentManage studentManage = context.getBean("studentManageImpl", StudentManage.class);
        ScoreManage scoreManage = context.getBean("scoreManageImpl", ScoreManage.class);
        try {
            userManage.login("1001", "123456", "学生");
            studentManage.queryStudent("1001");
            scoreManage.updateScore("1001");
        } catch (RuntimeException e) {
            System.out.println("异常信息：" + e.getMessage());
        } finally {
            userManage.quit();
        }

        ((AbstractApplicationContext) context).close();
    }
}

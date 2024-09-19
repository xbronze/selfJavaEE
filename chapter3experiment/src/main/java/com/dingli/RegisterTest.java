package com.dingli;

import com.dingli.chapter3experiment.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegisterTest {
    public static void main(String[] args) {
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("register-annotation.xml");
        // getBean方法获取初始化后的student对象
        Student student = context.getBean("student", Student.class);
        // student对象调用toString方法，输出对象中所有属性值
        System.out.println(student.toString());;
        ((AbstractApplicationContext) context).close();
    }
}
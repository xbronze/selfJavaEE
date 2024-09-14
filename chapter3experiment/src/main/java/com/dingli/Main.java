package com.dingli;

import com.dingli.chapter3experiment.Student;
import com.dingli.chapter3experiment.StudentAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // XML的构造方法实现依赖注入
        ApplicationContext context = new ClassPathXmlApplicationContext("register.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student.toString());

        // 注解的方式实现依赖注入
//        ApplicationContext context = new ClassPathXmlApplicationContext("register-annotation.xml");
//        StudentAnnotation studentAnnotation = context.getBean("studentAnnotation", StudentAnnotation.class);
//        System.out.println(studentAnnotation.toString());

        ((AbstractApplicationContext) context).close();
    }
}
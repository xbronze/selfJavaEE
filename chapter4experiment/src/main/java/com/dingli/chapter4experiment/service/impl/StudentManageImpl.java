package com.dingli.chapter4experiment.service.impl;

import com.dingli.chapter4experiment.service.StudentManage;
import org.springframework.stereotype.Component;

/**
*@author: xbronze
*@date: 2024-09-25 21:00
*@description: TODO
*/
@Component
public class StudentManageImpl implements StudentManage {
    @Override
    public void addStudent() {
        System.out.println("添加学生信息");
    }

    @Override
    public void updateStudent(String number) {
        System.out.println("更新学生信息");
    }

    @Override
    public void queryStudent(String number) {
        System.out.println("查询学生信息");
    }
}

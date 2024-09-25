package com.dingli.chapter4experiment.service.impl;

import com.dingli.chapter4experiment.service.ScoreManage;
import org.springframework.stereotype.Component;

/**
*@author: xbronze
*@date: 2024-09-25 21:00
*@description: TODO
*/
@Component
public class ScoreManageImpl implements ScoreManage {
    @Override
    public void addScore() {
        System.out.println("添加学生成绩");
    }

    @Override
    public void updateScore(String number) {
        System.out.println("更新学生成绩");
    }

    @Override
    public void querySocre(String number) {
        System.out.println("查询学生成绩");
    }
}

package com.dingli.chapter3experiment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-18 19:38
 * @description: TODO
 */
@Component
@Scope("singleton")
public class School {

    @Value("信阳师范大学")
    private String schoolName;

    @Value("河南省信阳市南湖路237号")
    private String schoolAddress;

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                '}';
    }
}

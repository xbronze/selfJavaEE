package com.dingli.chapter4experiment.test;

import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-25 17:21
 * @description: TODO
 */
@Component
public class UserServiceImpl implements UserService {
    @Override
    public void insert() {
        System.out.println("UserServiceImpl.insert()");
    }

    @Override
    public void update() {
        System.out.println("UserServiceImpl.update()");
    }
}

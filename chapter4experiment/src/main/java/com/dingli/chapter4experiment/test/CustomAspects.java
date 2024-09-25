package com.dingli.chapter4experiment.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-25 17:24
 * @description: TODO
 */
@Component
@Aspect  // 切面类
public class CustomAspects {

    @Before("execution(public void com.dingli.chapter4experiment.test.UserServiceImpl.*(..))")
    public void BeforeMetheod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "Before Method 被执行");
    }

}

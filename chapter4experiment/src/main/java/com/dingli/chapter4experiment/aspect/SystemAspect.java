package com.dingli.chapter4experiment.aspect;

import com.dingli.chapter4experiment.service.impl.UserManageImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
*@author: xbronze
*@date: 2024-09-25 21:02
*@description: TODO
*/
@Component
@Aspect
public class SystemAspect {

    UserManageImpl userManage = new UserManageImpl();

    public String getTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    @Pointcut("execution(* com.dingli.chapter4experiment.service.impl..*(..))")
    public void pointcut(){}

    @Before(value = "execution(* com.dingli.chapter4experiment.service.impl..add*(..))" +
        " || execution(* com.dingli.chapter4experiment.service.impl..update*(..))")
    public void adviseBefore1(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if ("学生".equals(userManage.getIdentity())) {
            throw new RuntimeException(userManage.getNumber() + " 用户无权限对 " + args.get(0) + " 进行 " + methodName + " 操作");
        }
    }

    @Before(value = "execution(* com.dingli.chapter4experiment.service.impl..add*(..))" +
            " || execution(* com.dingli.chapter4experiment.service.impl..update*(..))")
    public void adviseBefore2(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        if (userManage.getNumber() != args.get(0) && "学生".equals(userManage.getIdentity())) {
            throw new RuntimeException(userManage.getNumber() + " 用户无权限对 " + args.get(0) + " 进行 " + methodName + " 操作");
        }
    }

    @Around("pointcut()")
    public Object adviseAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(getTime());
        System.out.println(userManage.getNumber() + " 用户执行 " + joinPoint.getSignature().getName() + " 操作");
        Object obj = joinPoint.proceed();
        System.out.println(userManage.getNumber() + " 用户完成 " + joinPoint.getSignature().getName() + " 操作");
        return obj;
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void adviseThrow(JoinPoint joinPoint, RuntimeException e) {
        System.out.println("记录执行 " + joinPoint.getSignature().getName() + " 异常信息");
    }
}

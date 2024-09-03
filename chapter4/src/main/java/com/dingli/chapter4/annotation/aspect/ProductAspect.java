package com.dingli.chapter4.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: xbronze
 * @date: 2024-09-03 11:33
 * @description: TODO
 */
@Aspect
@Component
public class ProductAspect {

    @Pointcut("execution(* com.dingli.chapter4.annotation.service.impl.ProductImpl2.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void adviseBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "前置通知：权限验证……");
    }

    @After("pointcut()")
    public void adviseAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "后置通知：关闭文件……");
    }

    @Around("pointcut()")
    public Object adviseAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行前日志记录……");

        Object object = proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行后日志记录……");
        return object;
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void adviseThrow(JoinPoint joinPoint, Throwable e) {
        System.out.println(joinPoint.getSignature().getName() + "异常通知：" + e.getMessage());
    }

    @AfterReturning("pointcut()")
    public void adviseReturn(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "返回通知：释放资源……");
    }

}
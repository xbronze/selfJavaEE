package com.dingli.chapter4.xmlconfig.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author: xbronze
 * @date: 2024-09-03 11:33
 * @description: TODO
 */
public class ProductAspect {

    public void adviseBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "前置通知：权限验证……");
    }

    public void adviseAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "后置通知：关闭文件……");
    }

    public Object adviseAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行前日志记录……");

        Object object = proceedingJoinPoint.proceed();
        System.out.println(proceedingJoinPoint.getSignature().getName()
                + "环绕通知：执行后日志记录……");
        return object;
    }
    public void adviseThrow(JoinPoint joinPoint, Throwable e) {
        System.out.println(joinPoint.getSignature().getName() + "异常通知：" + e.getMessage());
    }
    public void adviseReturn(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "返回通知：释放资源……");
    }

}
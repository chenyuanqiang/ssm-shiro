package com.springBoot.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by cyq on 2017/12/4.
 */
@Aspect
@Component
public class UserAop {
    @Before("execution(* com.springBoot..*.*(..))")
    public void doMethod(JoinPoint joinPoint) {
        System.out.println("这个方法是在Controller以前调用的");
        System.out.println("方法的参数是name=" + joinPoint.getArgs()[0] + ":::password=" + joinPoint.getArgs()[1]);
    }
}

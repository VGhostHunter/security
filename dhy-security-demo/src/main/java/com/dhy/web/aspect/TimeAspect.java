package com.dhy.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author VGhostHunter
 */
// @Aspect
// @Component
public class TimeAspect {

    @Around("execution(* com.dhy.web.controller.UserController.*(..))")
    public Object handControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时：" + (System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return object;
    }
}

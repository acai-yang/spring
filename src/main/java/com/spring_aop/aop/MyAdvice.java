package com.spring_aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * DESC 通知类
 *
 * @author YangMingCai
 * @date 2023年02月24日 11:00
 */

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(void com.*..update())")
    //@Pointcut("execution(* com.spring_aop.*.*Service.update(..))")
    private void pt() {
    }

    @Around("pt()")
    public void addTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(System.currentTimeMillis());

        Object ret = pjp.proceed();
        Object[] args = pjp.getArgs();
        System.out.println(System.currentTimeMillis());


    }
}

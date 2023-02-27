package com.spring_mybatis.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 8:43
 */
@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.spring_mybatis.service.*.*(..))")
    public void pt() {
    }

    @Pointcut("execution(* com.spring_mybatis.service.*.openUrl(..))")
    public void trim() {
    }


    public void addTime(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            pjp.proceed();
        }

        long end = System.currentTimeMillis();

        System.out.println(declaringTypeName + "." + name + "  万次运行耗时：" + (end - start));
    }

    @Around("trim()")
    public void trimArgs(ProceedingJoinPoint jp) throws Throwable {

        Object[] args = jp.getArgs();
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].toString().trim();
        }

        jp.proceed(args);

    }
}

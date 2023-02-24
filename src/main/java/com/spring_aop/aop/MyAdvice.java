package com.spring_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    //@Pointcut("execution(void com.*..update())")
    @Pointcut("execution(* com.spring_aop.*.*Service.save(..))")
    private void pt() {
    }

    @Before("pt()")
    public void addTime() {
        System.out.println(System.currentTimeMillis());
    }
}

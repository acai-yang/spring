package com.spring_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月24日 10:58
 */
@Configuration
@ComponentScan("com.spring_aop")
@EnableAspectJAutoProxy
public class SpringConfig {
}

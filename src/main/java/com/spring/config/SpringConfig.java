package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月13日 15:14
 */
@Configuration
@ComponentScan({"com.spring"})
@PropertySource("classpath:jdbc.properties")
@Import(JDBCConfig.class)
public class SpringConfig {


}
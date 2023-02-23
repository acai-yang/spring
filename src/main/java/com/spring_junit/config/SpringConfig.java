package com.spring_junit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.spring_junit")
@PropertySource("jdbc.properties")
@Import({JDBCConfig.class, MybatisConfig.class})
public class SpringConfig {

}

package com.spring_mybatis.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.spring_mybatis")
@PropertySource("jdbc.properties")
@Import({JDBCConfig.class, MybatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {

}

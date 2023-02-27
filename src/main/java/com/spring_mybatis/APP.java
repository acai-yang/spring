package com.spring_mybatis;

import com.spring_mybatis.config.SpringConfig;
import com.spring_mybatis.service.UrlService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UrlService service = context.getBean(UrlService.class);


    }
}

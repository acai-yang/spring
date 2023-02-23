package com.spring_mybatis;

import com.spring_mybatis.config.SpringConfig;
import com.spring_mybatis.pojo.User;
import com.spring_mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class APP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService service = context.getBean(UserService.class);

        List<User> list = service.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

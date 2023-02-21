package com.mybatis;

import com.mybatis.config.SpringConfig;
import com.mybatis.pojo.User;
import com.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class APP {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService bean = context.getBean(UserService.class);

        List<User> list = bean.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

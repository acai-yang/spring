package com.spring_junit;

import com.spring_junit.config.SpringConfig;
import com.spring_junit.pojo.User;
import com.spring_junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class APP {
    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService service = context.getBean(UserService.class);

        List<User> list = service.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

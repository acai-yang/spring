package com.spring_transaction;


import com.spring_transaction.config.SpringConfig;
import com.spring_transaction.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class APP {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountService accountService = context.getBean(AccountService.class);
        accountService.transfer("A", "B", 100D);
    }
}

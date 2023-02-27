package com.spring_transaction.service.impl;

import com.spring_transaction.dao.AccountDao;
import com.spring_transaction.service.AccountService;
import com.spring_transaction.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 10:39
 */
@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    public void transfer(String out, String in, Double money) throws IOException {
        try {
            accountDao.outMoney(out, money);
           /* if (true) {
                throw new IOException();
            }*/
            accountDao.inMoney(in, money);
        } finally {
            logService.log(out, in, money);
        }
    }
}

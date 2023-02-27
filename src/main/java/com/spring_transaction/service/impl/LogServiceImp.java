package com.spring_transaction.service.impl;

import com.spring_transaction.dao.LogDao;
import com.spring_transaction.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 13:58
 */
@Service
public class LogServiceImp implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void log(String out, String in, Double money) {
        logDao.log("转账操作由" + out + "到" + in + ",金额：" + money);
    }
}

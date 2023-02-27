package com.spring_transaction.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 10:25
 */
public interface AccountService {
    @Transactional(rollbackFor = {IOException.class})
    void transfer(String out, String in, Double money) throws IOException;
}

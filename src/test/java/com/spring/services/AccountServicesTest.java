package com.spring.services;

import com.spring.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月14日 16:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServicesTest {

    @Autowired
    private Services services;


    @Test
    public void servicesTest() {
        services.fun();
    }
}

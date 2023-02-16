package com.spring.services;

import com.spring.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月06日 13:13
 */
//@Component
@Service
public class ServicesImp implements Services {

    @Autowired
    @Qualifier("dao")
    private Dao dao;

    @Override
    public void fun() {
        System.out.println("Services#fun()");
        dao.fun();
    }
}

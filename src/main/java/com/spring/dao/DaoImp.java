package com.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月06日 13:13
 */
//@Component("dao")
@Repository("dao")
//@Controller
//@Scope("singleton")
//@Scope("prototype")
public class DaoImp implements Dao {
    @Value("${username2}")
    private String name;

    @Override
    public void fun() {
        System.out.println("DaoImp#fun()" + name);

    }

}

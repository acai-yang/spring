package com.spring_aop.dao.daoimp;

import com.spring_aop.dao.Dao;
import org.springframework.stereotype.Repository;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月24日 10:56
 */

@Repository
public class UserDao implements Dao {
    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("UserDao#save()");
    }

    @Override
    public void update() {
        System.out.println("UserDao#update()");
    }
}

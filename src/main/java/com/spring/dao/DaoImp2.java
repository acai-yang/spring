package com.spring.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月09日 15:37
 */
public class DaoImp2 implements Dao, InitializingBean, DisposableBean {


    public void fun() {
        System.out.println("DaoImp2#fun()");
    }

    public void init() {
        System.out.println("DaoImp2#init()");
    }

    public void close() {
        System.out.println("DaoImp2#claose()");
    }

    public void destroy() throws Exception {
        System.out.println("close");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}

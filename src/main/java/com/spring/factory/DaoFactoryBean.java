package com.spring.factory;

import com.spring.dao.Dao;
import com.spring.dao.DaoImp;
import org.springframework.beans.factory.FactoryBean;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月06日 17:34
 */
public class DaoFactoryBean implements FactoryBean<Dao> {
    public Dao getObject() throws Exception {
        return new DaoImp();
    }

    public Class<?> getObjectType() {
        return DaoImp.class;
    }

    public boolean isSingleton() {
        return false;
    }
}

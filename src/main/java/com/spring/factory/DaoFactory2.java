package com.spring.factory;

import com.spring.dao.Dao;
import com.spring.dao.DaoImp;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月09日 15:26
 */
public class DaoFactory2 {
    public Dao getDao() {
        return new DaoImp();
    }
}

package com.spring.factory;

import com.spring.dao.Dao;
import com.spring.dao.DaoImp;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月09日 15:21
 */
public class DaoFactory {
    public static Dao getDaoBean() {
        return new DaoImp();
    }
}

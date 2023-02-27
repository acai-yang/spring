package com.spring_transaction.dao;

import org.apache.ibatis.annotations.Insert;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 14:03
 */
public interface LogDao {
    @Insert("insert into user_log (info,createDate) values(#{info},now())")
    void log(String info);
}

package com.spring_transaction.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月27日 10:33
 */
public interface AccountDao {

    @Update("update user set money = money + #{money} where name = #{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update user set money = money - #{money} where name = #{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);
}

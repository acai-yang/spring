package com.spring.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月14日 15:39
 */
public class Mybatis {
    public void getMyBatisDataSource() throws IOException {
        //1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.加载SqlMapConfig.xml配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConifg.xml");

    }
}

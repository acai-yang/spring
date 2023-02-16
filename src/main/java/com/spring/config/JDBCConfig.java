package com.spring.config;

import com.spring.dao.Dao;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月14日 12:44
 */

public class JDBCConfig {

    @Value("com.mysql.jdbc.Driver")
    private String DriverClassNam;


    @Bean
    public DataSource dataSource(Dao dao) {
        System.out.println(dao);
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(DriverClassNam);
        return dataSource;
    }
}

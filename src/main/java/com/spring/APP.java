package com.spring;

import com.spring.config.SpringConfig;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * DESC Spring学习测试
 *
 * @author YangMingCai
 * @date 2023年02月06日 13:10
 */
public class APP {
    public static void main(String[] args) {

        //1.加载类路径下的配置类
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);


        //4.获取bean方式二
        // Services services = ctx.getBean(Services.class);
        //Services services = ctx.getBean(Services.class);
        DataSource bean = ctx.getBean(DataSource.class);

        System.out.println(bean);

        new SqlSessionFactoryBuilder();

    }
}

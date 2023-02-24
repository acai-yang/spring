package com.spring_aop;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月24日 11:31
 */
public class APP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao bean = ctx.getBean(Dao.class);
        bean.update();
    }
}

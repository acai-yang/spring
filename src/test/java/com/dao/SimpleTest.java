package com.dao;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * DESC 测试
 *
 * @author YangMingCai
 * @date 2023年02月16日 9:56
 */
public class SimpleTest {
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        userDao = new UserDao("MyBatis_Config.xml");
    }

    @Test
    public void insertTest() {
        User user = new User();
        user.setId(2);
        user.setName("acai");
        user.setAge(28);

        int i = userDao.addUser(user);
        System.out.println(i);
        System.out.println(i);
    }

    @Test
    public void findAllTest() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}

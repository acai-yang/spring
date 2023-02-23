package com.spring_mybatis.dao;

import com.spring_mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月16日 9:41
 */
public class UserDao {
    private final SqlSessionFactory sessionFactory;


    public UserDao(String configPath) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(configPath);
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    public List<User> findAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> userList = sqlSession.selectList("findAll");
        sqlSession.close();
        return userList;
    }

    public int addUser(User user) {
        SqlSession sqlSession = sessionFactory.openSession();
        int addCount = sqlSession.insert("insert", user);
        sqlSession.commit();
        sqlSession.close();
        return addCount;
    }

    public int deleteUser(int id) {
        SqlSession sqlSession = sessionFactory.openSession();
        int deleteCount = sqlSession.delete("delete", id);
        sqlSession.commit();
        sqlSession.close();
        return deleteCount;
    }


}

package com.spring_mybatis.service;

import com.spring_mybatis.pojo.User;

import java.util.List;

public interface UserService {

    void sava(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);

    List<User> findAll();
}

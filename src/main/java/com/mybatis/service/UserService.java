package com.mybatis.service;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserService {

    void sava(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);

    List<User> findAll();
}

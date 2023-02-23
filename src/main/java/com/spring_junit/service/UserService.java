package com.spring_junit.service;

import com.spring_junit.pojo.User;

import java.util.List;

public interface UserService {

    void sava(User user);

    void update(User user);

    void delete(Integer id);

    User findById(Integer id);

    List<User> findAll();
}

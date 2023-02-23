package com.spring_junit.service.impl;

import com.spring_junit.dao.UserDao2;
import com.spring_junit.pojo.User;
import com.spring_junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao2 userDao2;

    @Override
    public void sava(User user) {
        userDao2.save(user);
    }

    @Override
    public void update(User user) {
        userDao2.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao2.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao2.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao2.findAll();

    }
}

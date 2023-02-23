package com.spring_mybatis.dao;

import com.spring_mybatis.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

 public interface UserDao2 {


    @Insert("insert into user(id,name,age) values(#{id},#{name},#{age})")
    void save(User user);

    @Delete("delete from user where id = #{id}")
    void delete(Integer id);

    @Update("update user set name = #{name},age = #{age} where id = #{id}")
    void update(User user);

    @Select("select * from user;")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

}

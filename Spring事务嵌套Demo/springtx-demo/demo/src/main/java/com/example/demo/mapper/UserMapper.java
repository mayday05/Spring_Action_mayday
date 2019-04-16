package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(userId, userName, email) VALUES (#{userId}, #{userName}, #{email})")
    void insert(User user);

    @Select("SELECT * FROM user")
    void selectOne();

}

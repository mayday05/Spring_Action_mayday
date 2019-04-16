package com.example.demo.scene1;

import com.example.demo.controller.UserService;
import com.example.demo.mapper.UserArticleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserArticle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 实例化Manager
 */
@Service("userService1")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserArticleMapper userArticleMapper;

    @Transactional
    @Override
    public void parent() {
        userMapper.insert(new User("12345", "mayday", "912002367@qq.com"));
    }

    @Transactional
    @Override
    public void child() {
        userArticleMapper.insert(new UserArticle("12345", "124", "title123", "hello world"));
    }

    @Override
    public void get() {
        userMapper.selectOne();
    }

}

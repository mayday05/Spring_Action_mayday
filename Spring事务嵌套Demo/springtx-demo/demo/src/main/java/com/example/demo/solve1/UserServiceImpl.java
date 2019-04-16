package com.example.demo.solve1;

import com.example.demo.controller.UserService;
import com.example.demo.mapper.UserArticleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserArticle;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 实例化Manager
 */
@Service("userService5")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserArticleMapper userArticleMapper;

    // 这里的Propagation是事务的传播行为，默认是REQUIRED，
    // 意思是如果当前没有事务，就开启一个事务，如果已经存在一个事务，就加入到这个事务中；
    @Transactional
    @Override
    public void parent() {
        userMapper.insert(new User("123456", "mayday", "912002367@qq.com"));

        try {
            // this.child();
            ((UserServiceImpl)AopContext.currentProxy()).child(); // 使用AopContext方式
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 传播设置成REQUIRES_NEW，不管有没有就新建一个事务（如果有其他事务先挂起）
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void child() {
        userArticleMapper.insert(new UserArticle("123456", "124", "title123", "hello world"));
        System.out.println(1 / 0); // 构造异常
    }

    @Override
    public void get() {
        userMapper.selectOne();
    }

}

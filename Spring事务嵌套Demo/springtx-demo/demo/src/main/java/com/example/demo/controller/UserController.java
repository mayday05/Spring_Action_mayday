package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableTransactionManagement // 开启事务管理区
@EnableAspectJAutoProxy(exposeProxy = true) // 注解开启 exposeProxy = true，暴露代理对象 (否则AopContext.currentProxy()) 会抛出异常。
@RequestMapping(value = "/user")
public class UserController {

    @Resource(name = "userService6") // 可以指定bean名称，切换manager类
    private UserService userService;

    @RequestMapping(value = "/add")
    public String add() {
        userService.parent();
        return "OK";
    }

    @RequestMapping(value = "/get")
    public String get() {
        userService.get();
        return "OK";
    }

}

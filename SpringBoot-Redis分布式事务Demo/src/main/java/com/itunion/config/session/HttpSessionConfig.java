package com.itunion.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableSpringHttpSession // 启动http session 注解
public class HttpSessionConfig {

    // session策略，这里默认会从头部，请求参数中获取内容
    // 这里的token 可以自定义，主要用于请求参数的名字
    @Bean
    HttpSessionStrategy httpSessionStrategy() {
        return new WxHttpSessionStrategy("token");
    }

    @Bean
    WxRedisSessionRepository sessionRepository(RedisTemplate redisTemplate) {
        return new WxRedisSessionRepository(redisTemplate, 3600);
    }
}

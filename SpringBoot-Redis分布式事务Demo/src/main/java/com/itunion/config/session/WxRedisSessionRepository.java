package com.itunion.config.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.ExpiringSession;
import org.springframework.session.SessionRepository;

import java.util.concurrent.TimeUnit;

/**
 * 主要用来管理session对象
 */
public class WxRedisSessionRepository implements SessionRepository<WxRedisSession> {
    private static Logger log = LoggerFactory.getLogger(WxRedisSessionRepository.class);

    // redis 连接工具
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 如果不为空，将覆盖默认的超时时间，单位秒
     * {@link ExpiringSession#setMaxInactiveIntervalInSeconds(int)}.
     */
    private Integer defaultMaxInactiveInterval;

    public WxRedisSessionRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public WxRedisSessionRepository(RedisTemplate<String, Object> redisTemplate, Integer defaultMaxInactiveInterval) {
        this.redisTemplate = redisTemplate;
        this.defaultMaxInactiveInterval = defaultMaxInactiveInterval;
    }

    @Override
    public WxRedisSession createSession() {
        WxRedisSession session = new WxRedisSession();
        log.debug("createSession " + session.getId());
        return session;
    }

    @Override
    public void save(WxRedisSession session) {
        log.debug("save " + session.getId());
        redisTemplate.opsForValue().set(session.getId(), session, defaultMaxInactiveInterval, TimeUnit.SECONDS);
    }

    @Override
    public WxRedisSession getSession(String id) {
        log.debug("getSession " + id);
        if (redisTemplate.hasKey(id)) {
            return (WxRedisSession) redisTemplate.opsForValue().get(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        log.debug("delete " + id);
        redisTemplate.delete(id);
    }

    public void setDefaultMaxInactiveInterval(Integer defaultMaxInactiveInterval) {
        this.defaultMaxInactiveInterval = defaultMaxInactiveInterval;
    }
}

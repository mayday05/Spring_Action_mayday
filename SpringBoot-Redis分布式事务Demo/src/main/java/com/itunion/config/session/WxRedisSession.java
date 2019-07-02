package com.itunion.config.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.session.ExpiringSession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 因为Filter 拦截器自动注入的是 ExpiringSession 类型的Session
 * 所以这边实现的 ExpiringSession 方法可以不用管，用JsonIgnore 忽略防止反序列化失败
 */
public class WxRedisSession implements ExpiringSession, Serializable {

    private String id;
    private Map<String, Object> sessionAttrs = new HashMap<String, Object>();

    public WxRedisSession() {
        this(UUID.randomUUID().toString().replace("-", ""));
    }

    public WxRedisSession(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public <T> T getAttribute(String attributeName) {
        return (T) this.sessionAttrs.get(attributeName);
    }

    @JsonIgnore
    @Override
    public Set<String> getAttributeNames() {
        return this.sessionAttrs.keySet();
    }

    @Override
    public void setAttribute(String attributeName, Object attributeValue) {
        if (attributeValue == null) {
            removeAttribute(attributeName);
        } else {
            this.sessionAttrs.put(attributeName, attributeValue);
        }
    }

    @Override
    public void removeAttribute(String attributeName) {
        this.sessionAttrs.remove(attributeName);
    }

    public void setId(String id) {
        this.id = id;
    }

    //   反序列化需要用到get set方法
    public Map<String, Object> getSessionAttrs() {
        return sessionAttrs;
    }

    public void setSessionAttrs(Map<String, Object> sessionAttrs) {
        this.sessionAttrs = sessionAttrs;
    }

    // redis 会自动销毁 session ,所以不需要使用下面的方法
    @JsonIgnore
    @Override
    public long getCreationTime() {
        return 0;
    }

    @JsonIgnore
    @Override
    public void setLastAccessedTime(long lastAccessedTime) {
    }

    @JsonIgnore
    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @JsonIgnore
    @Override
    public void setMaxInactiveIntervalInSeconds(int interval) {
    }

    @JsonIgnore
    @Override
    public int getMaxInactiveIntervalInSeconds() {
        return 0;
    }

    @JsonIgnore
    @Override
    public boolean isExpired() {
        return false;
    }
}

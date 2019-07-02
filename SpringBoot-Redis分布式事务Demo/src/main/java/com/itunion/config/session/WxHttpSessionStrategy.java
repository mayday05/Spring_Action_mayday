package com.itunion.config.session;

import org.springframework.session.Session;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义会话策略, 比如会话的标识从哪里获取
 */
public class WxHttpSessionStrategy implements HttpSessionStrategy {
    private String name;

    public WxHttpSessionStrategy() {
        this("token");
    }

    public WxHttpSessionStrategy(String name) {
        this.name = name;
    }

    @Override
    public String getRequestedSessionId(HttpServletRequest request) {
        // 从header 中获取
        String token = request.getHeader(name);
        if (token != null) return token;

        // 从请求参数中获取
        token = request.getParameter(name);
        if (token != null) return token;

        // 增加自己的获取方式 比如：cookie
        return null;
    }

    @Override
    public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader(this.name, session.getId());
    }

    @Override
    public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader(this.name, "");
    }

    public void setName(String name) {
        this.name = name;
    }
}

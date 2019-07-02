package com.itunion.model;

import java.io.Serializable;

public class User implements Serializable {
    private String nickName;
    private String loginBy;
    private String token;

    public User() {
    }

    public User(String nickName, String loginBy, String token) {
        this.nickName = nickName;
        this.loginBy = loginBy;
        this.token = token;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getLoginBy() {
        return loginBy;
    }

    public void setLoginBy(String loginBy) {
        this.loginBy = loginBy;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", loginBy='" + loginBy + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

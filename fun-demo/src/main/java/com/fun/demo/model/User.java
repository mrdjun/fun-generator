package com.fun.demo.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户信息
 * @author tangbing
 * @date 2021-03-14
 */
public class User implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
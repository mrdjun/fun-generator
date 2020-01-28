package com.fun.project.entity;

import com.fun.common.web.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author DJun
 * @date 2020/01/28
 */
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 登录账号
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String password;
}
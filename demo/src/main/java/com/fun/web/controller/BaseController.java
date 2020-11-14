package com.fun.web.controller;


import com.fun.utils.StringUtils;

/**
 * @author DJun
 */
public class BaseController {
    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }

    /**
     * 这里可以做Controller的通用方法：比如获取当前用户登录账号、用户ID等信息
     */
}

package com.fun.common.web.controller;


import com.fun.common.utils.StringUtils;


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

}

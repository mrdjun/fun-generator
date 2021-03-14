package com.fun.demo.service;

import com.fun.demo.model.User;
import com.fun.demo.util.PageInfoEvt;
import com.fun.demo.util.R;

import java.util.List;

/**
 * 用户信息
 * @author fun
 * @date 2021-03-14
 */
public interface UserService {

    /**
     * 新增用户信息
     *
     */
    R insert(User user);

    /**
     * 删除用户信息
     *
     */
    R removeById(long userId);

    /**
     * 通过id批量删除用户信息
     *
     */
    R removeByIds(String userIds);

    /**
     * 修改用户信息
     *
     */
    R edit(User user);

    /**
     * 通过Id查询用户信息
     *
     */
    User getById(long userId);

    /**
     * 分页查询用户信息
     *
     */
    List<User> list(User user, PageInfoEvt evt);
}


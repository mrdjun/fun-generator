package com.fun.demo.service.impl;

import com.fun.demo.dao.UserMapper;
import com.fun.demo.model.User;
import com.fun.demo.service.UserService;
import com.fun.demo.util.Convert;
import com.fun.demo.util.PageInfoEvt;
import com.fun.demo.util.R;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息
 * @auther fun
 * @date 2021-03-14
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 新增用户信息
     *
     */
    @Override
    public R insert(User user) {
        return userMapper.insert(user) > 0 ? R.success() : R.error();
    }

    /**
     * 删除用户信息
     *
     */
    @Override
    public R removeById(long userId) {
        return userMapper.deleteById(userId) > 0 ? R.success() : R.error();
    }

    /**
     * 通过id批量删除用户信息
     *
     */
    @Override
    public R removeByIds(String userIds) {
        return userMapper.deleteByIds(Convert.toStrArray(userIds))> 0 ? R.success() : R.error();
    }

    /**
     * 修改用户信息
     *
     */
    @Override
    public R edit(User user) {
        return userMapper.update(user) > 0 ? R.success() : R.error();
    }

    /**
     * 通过Id查询用户信息
     *
     */
    @Override
    public User getById(long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 分页查询用户信息
     *
     */
    @Override
    public List<User> list(User user, PageInfoEvt evt) {
        PageHelper.startPage(evt.getPageNum(), evt.getPageSize());
        return userMapper.selectList(user);
    }

}


package com.fun.project.service.impl;

import com.fun.common.utils.text.Convert;
import com.fun.project.entity.User;
import com.fun.project.mapper.UserMapper;
import com.fun.project.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJun
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList(User user,int pageNum,int pageSize) {
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->userMapper.selectUserList(user));
    }

    @Override
    public User selectUserById(long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(long userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int deleteUserByIds(String userIds) {
        return userMapper.deleteUserByIds(Convert.toStrArray(userIds));
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}

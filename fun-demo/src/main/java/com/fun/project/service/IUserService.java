package com.fun.project.service;

import com.fun.project.entity.User;

import java.util.List;

/**
 * 【功能名】 业务层
 * 例：用户 业务层
 * @author DJun
 */
public interface IUserService {

    List<User> selectUserList(User user,int pageNum,int pageSize);

    User selectUserById(long userId);

    int insertUser(User user);

    int deleteUserById(long userId);

    int deleteUserByIds(String userIds);

    int updateUser(User user);

}

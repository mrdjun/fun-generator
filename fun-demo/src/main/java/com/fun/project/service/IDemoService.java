package com.fun.project.service;

import com.fun.project.entity.Demo;

import java.util.List;

/**
 * 【功能名】 业务层
 * 例：用户 业务层
 * @author DJun
 */
public interface IDemoService {

    List<Demo> selectUserList(Demo demo, int pageNum, int pageSize);

    Demo selectUserById(long userId);

    int insertUser(Demo demo);

    int deleteUserById(long userId);

    int deleteUserByIds(String userIds);

    int updateUser(Demo demo);

}

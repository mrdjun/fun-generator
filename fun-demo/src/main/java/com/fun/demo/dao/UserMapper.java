package com.fun.demo.dao;

import com.fun.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户信息
 * @author fun
 * @date 2021-03-14
 */
public interface UserMapper {

    /**
     * 新增用户信息
     *
     */

    int insert(User user);

    /**
     * 删除用户信息
     *
     */
    int deleteById( long userId);


    /**
     * 通过id批量删除用户信息
     *
     */
    int deleteByIds(String[] userIds);



    /**
     * 修改用户信息
     *
     */
    int update(User user);


    /**
     * 通过Id查询用户信息
     *
     */
    User selectById(long userId);


    /**
     * 分页查询用户信息
     *
     */
    List<User> selectList(User user);



}
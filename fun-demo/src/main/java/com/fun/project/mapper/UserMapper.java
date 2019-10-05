package com.fun.project.mapper;


import com.fun.project.entity.User;

import java.util.List;

/**
 * 模板：【功能名】 DAO
 * 例：用户 DAO
 * @author DJun
 */
public interface UserMapper {

    /**
     * 模板：查询【功能名】 列表
     * 例：查询 用户 列表
     * @param user 【功能名】 对象
     * @return 【功能名】列表
     */
    List<User> selectUserList(User user);

    /**
     * 模板：通过Id查询【功能名】
     * 例：通过Id查询 用户
     * @param userId 【功能名】 Id
     * @return 【功能名】对象
     */
    User selectUserById(long userId);

    /**
     * 模板：新增【功能名】
     * 例：新增 用户
     * @param user 【功能名】 对象
     * @return 插入行数
     */
    int insertUser(User user);


    /**
     * 模板：修改【功能名】信息
     * 例：修改 用户 信息
     * @param userId 【功能名】id
     * @return 删除行数
     */
    int deleteUserById(long userId);


    /**
     * 模板：通过id删除【功能名】
     * 例：通过id删除 用户
     * @param userIds 【功能名】ids
     * @return 删除行数
     */
    int deleteUserByIds(String[] userIds);

    /**
     * 模板：通过id批量删除【功能名】
     * 例：通过id 批量删除 用户
     *
     * @param user 用户对象
     * @return 更新行数
     */
    int updateUser(User user);

}

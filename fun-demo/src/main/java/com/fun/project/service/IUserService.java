package com.fun.project.service;

import com.fun.project.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author DJun
 * @date 2020/1/28
 */
public interface IUserService {

    /**
     * 查询User列表
     *
     * @param user 查询对象
     * @return 查询列表
     */
    List<User> selectUserList(User user, int pageNum, int pageSize);

    /**
     * 通过Id查询 User
     *
     * @param userId 查询Id
     * @return 查询对象
     */
    User selectUserById(long userId);

    /**
     * 新增User
     *
     * @param user 新增对象
     * @return 插入行数
     */
    int insertUser(User user);

    /**
     * 修改User信息
     *
     * @param user 用户对象
     * @return 更新行数
     */
    int updateUser(User user);

    /**
     * 通过id删除User
     *
     * @param userId 删除id
     * @return 删除行数
     */
    int deleteUserById(long userId);

    /**
     * 通过id批量删除User
     *
     * @param userIds 删除ids
     * @return 删除行数
     */
    int deleteUserByIds(String userIds);

    /**
     * 登录
     *
     * @param user loginName,password
     * @return User/null
     */
    User login(User user) throws NoSuchAlgorithmException;

    /**
     * 校验账号唯一
     *
     * @param loginName 账号
     * @return 0/1
     */
    int checkLoginNameUnique(String loginName);
}

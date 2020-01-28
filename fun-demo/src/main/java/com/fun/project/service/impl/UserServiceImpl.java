package com.fun.project.service.impl;

import com.fun.common.utils.DateUtils;
import com.fun.common.utils.MD5Utils;
import com.fun.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import com.fun.common.utils.text.Convert;
import com.fun.project.mapper.UserMapper;
import com.fun.project.service.IUserService;
import com.fun.project.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * @author DJun
 * @date 2020/1/28
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过Id查询 User
     */
    @Override
    public User selectUserById(long userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 查询User列表
     */

    @Override
    public List<User> selectUserList(User user, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userMapper.selectUserList(user));
    }

    /**
     * 新增User
     */
    @Override
    public int insertUser(User user) {
        String p = user.getPassword();
        try {
            user.setPassword(MD5Utils.getEncryptedPwd(p));
        } catch (NoSuchAlgorithmException e) {
            log.error("加密异常", e);
            return 0;
        }
        return userMapper.insertUser(user);
    }

    /**
     * 通过id删除User
     */
    @Override
    public int deleteUserById(long userId) {
        return userMapper.deleteUserById(userId);
    }

    /**
     * 通过id批量删除User
     */
    @Override
    public int deleteUserByIds(String userIds) {
        return userMapper.deleteUserByIds(Convert.toStrArray(userIds));
    }

    /**
     * 修改User信息
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User login(User user) throws NoSuchAlgorithmException {
        User loginUser = userMapper.login(user.getLoginName());
        boolean isSuc = false;
        if (StringUtils.isNotNull(loginUser)) {
            isSuc = MD5Utils.validPassword(user.getPassword(), loginUser.getPassword());
        }
        if (isSuc) {
            loginUser.setPassword("it's a secret.");
            return loginUser;
        }
        return null;
    }

    @Override
    public int checkLoginNameUnique(String loginName) {
        return userMapper.checkLoginNameUnique(loginName);
    }
}

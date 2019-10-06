package com.fun.project.service.impl;

import com.fun.common.utils.text.Convert;
import com.fun.project.entity.Demo;
import com.fun.project.mapper.DemoMapper;
import com.fun.project.service.IDemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJun
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> selectUserList(Demo demo, int pageNum, int pageSize) {
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()-> demoMapper.selectUserList(demo));
    }

    @Override
    public Demo selectUserById(long userId) {
        return demoMapper.selectUserById(userId);
    }

    @Override
    public int insertUser(Demo demo) {
        return demoMapper.insertUser(demo);
    }

    @Override
    public int deleteUserById(long userId) {
        return demoMapper.deleteUserById(userId);
    }

    @Override
    public int deleteUserByIds(String userIds) {
        return demoMapper.deleteUserByIds(Convert.toStrArray(userIds));
    }

    @Override
    public int updateUser(Demo demo) {
        return demoMapper.updateUser(demo);
    }
}

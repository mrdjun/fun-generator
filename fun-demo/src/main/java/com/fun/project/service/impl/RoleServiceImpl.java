package com.fun.project.service.impl;
import com.fun.common.utils.text.Convert;
import com.fun.project.entity.Role;
import com.fun.project.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.project.mapper.RoleMapper;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date 2019/10/06
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 通过Id查询 Role
     */
    @Override
    public Role selectRoleById(long roleId) {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 查询Role列表
     */

    @Override
    public List<Role> selectRoleList(Role role, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->roleMapper.selectRoleList(role));
    }

    /**
     * 新增Role
     */
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    /**
     * 通过id删除Role
     */
    @Override
    public int deleteRoleById(long roleId) {
        return roleMapper.deleteRoleById(roleId);
    }

    /**
     * 通过id批量删除Role
     */
    @Override
    public int deleteRoleByIds(String roleIds){
        return roleMapper.deleteRoleByIds(Convert.toStrArray(roleIds));
    }

    /**
     * 修改Role信息
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

}

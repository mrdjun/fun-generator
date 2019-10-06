package com.fun.project.mapper;

import com.fun.project.entity.Role;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date 2019/10/06
 */
public interface RoleMapper {

    /**
     * 查询Role列表
     * @param role 查询对象
     * @return 查询列表
     */
    List<Role> selectRoleList(Role role);

    /**
     * 通过Id查询 Role
     * @param roleId 查询Id
     * @return 查询对象
     */
    Role selectRoleById(long roleId);

    /**
     * 新增Role
     * @param role 新增对象
     * @return 插入行数
     */
    int insertRole(Role role);

    /**
     * 修改Role信息
     * @param  role 用户对象
     * @return 更新行数
     */
    int updateRole(Role role);

    /**
     * 通过id删除Role
     * @param roleId 删除id
     * @return 删除行数
     */
    int deleteRoleById(long roleId);

    /**
     * 通过id批量删除Role
     * @param roleIds 删除ids
     * @return 删除行数
     */
    int deleteRoleByIds(String[] roleIds);

}

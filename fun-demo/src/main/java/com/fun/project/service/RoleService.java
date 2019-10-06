package com.fun.project.service;
import java.util.List;
import com.fun.project.entity.Role;

/**
 *
 * @author u-fun
 * @date 2019/10/06
 */
public interface RoleService {

    /**
     * 查询Role列表
     */
    List<Role> selectRoleList(Role role,int pageNum,int pageSize);

    /**
     * 通过Id查询 Role
     */
    Role selectRoleById(long roleId);

    /**
     * 新增Role
     */
    int insertRole(Role role);

    /**
     * 通过id删除Role
     */
    int deleteRoleById(long roleId);

    /**
     * 通过id批量删除Role
     */
    int deleteRoleByIds(String roleIds);

    /**
     * 修改Role信息
     */
    int updateRole(Role role);

}

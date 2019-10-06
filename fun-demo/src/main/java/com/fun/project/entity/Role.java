package com.fun.project.entity;
import com.fun.common.web.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 *
 * @author u-fun
 * @date 2019/10/06
 */
@Getter
@Setter
@ToString
public class Role extends BaseEntity {
    /**
     *
     */
    private Long roleId;
    /**
     *
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleKey;
    /**
     * 显示顺序
     */
    private int roleSort;

    /**
     * 2-已删除1-正常
     */
    private String delFlag;
}
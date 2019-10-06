package com.fun.project.entity;

import com.fun.common.web.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author DJun
 */
@Getter
@Setter
@ToString
public class Demo extends BaseEntity {

    private Long userId;

    private String username;

    private String password;

}

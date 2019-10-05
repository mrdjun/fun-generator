package com.fun.project.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DJun
 */
@Data
public class User implements Serializable {

    private Long userId;

    private String username;

    private String password;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;


}

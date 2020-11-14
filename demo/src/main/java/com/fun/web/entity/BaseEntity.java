package com.fun.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;


/**
 * Entity 基类
 *
 * @author DJun
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String status;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 搜索值
     */
    private String searchValue;
    /**
     * 备注
     */
    private String remark;
    /**
     * 请求参数
     */
    private Map<String, Object> params;
}

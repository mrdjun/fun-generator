package com.fun.common.web.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;


/**
 * Entity 基类
 * @author DJun
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 时间戳 */
    private Long createTime;
    private Long updateTime;
    private String status;
    /** 创建者 */
    private String createBy;
    /** 更新者 */
    private String updateBy;
    /** 搜索值 */
    private String searchValue;
    /** 备注 */
    private String remark;
    /** 请求参数 */
    private Map<String, Object> params;
}

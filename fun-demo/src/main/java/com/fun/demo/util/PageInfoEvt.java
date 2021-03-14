package com.fun.demo.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author DengJun 2021/3/10
 */
@Getter
@Setter
public class PageInfoEvt implements Serializable {
    private static final long serialVersionUID = 8643419100013445741L;

    @ApiModelProperty(value = "当前页码", required = true)
    private int pageNum = 1;

    @ApiModelProperty(value = "当前页数据数量", required = true)
    private int pageSize = 10;

}

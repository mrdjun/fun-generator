package com.fun.utils;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author DJun
 */
@Data
public class CommonPage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage();
        PageInfo<T> pageInfo = new PageInfo(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

}


package com.fun.generator.core.pojo;

import lombok.Data;

import java.util.List;

/**
 * created by DJun on 2019/8/10 23:04
 * desc:
 */
@Data
public class ClassInfo {
    private String tableName;
    private String className;
    private String classComment;
    private List<FieldInfo> fieldList;

}

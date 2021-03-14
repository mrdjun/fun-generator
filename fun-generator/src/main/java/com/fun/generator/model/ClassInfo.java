package com.fun.generator.model;

import lombok.Data;

import java.util.List;

/**
 * class info
 *
 * @author xuxueli 2018-05-02 20:02:34
 */
@Data
public class ClassInfo {
    private String tableName;
    private String tableRealName;
    private String className;
    private String classComment;
    private String primaryKey;
    private String primaryKeyId;
    private List<FieldInfo> fieldList;
}
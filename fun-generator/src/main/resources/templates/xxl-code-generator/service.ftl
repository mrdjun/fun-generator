package com.fun.project.service;
import java.util.Map;
/**
 * ${classInfo.classComment}
 *
 * @author u-fun
 * @date ${.now?string('yyyy/MM/dd')}
 */
public interface ${classInfo.className}Service {

    /**
     * 查询${classInfo.className}列表
     */
    List<${classInfo.className}> select${classInfo.className}List(${classInfo.className} ${classInfo.className?uncap_first},int pageNum,int pageSize);

    /**
     * 通过Id查询 ${classInfo.className}
     */
    ${classInfo.className} select${classInfo.className}ById(long ${classInfo.conversionPrimaryKey});

    /**
     * 新增${classInfo.className}
     */
    int insert${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first});

    /**
     * 通过id删除${classInfo.className}
     */
    int delete${classInfo.className}ById(long ${classInfo.conversionPrimaryKey});

    /**
     * 通过id批量删除${classInfo.className}
     */
    int delete${classInfo.className}ByIds(String ${classInfo.conversionPrimaryKey}s);

    /**
     * 修改${classInfo.className}信息
     */
    int update${classInfo.className}(${classInfo.className} ${classInfo.className?uncap_first});

}

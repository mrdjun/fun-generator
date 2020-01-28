package com.fun.project.entity;
<#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
    <#list classInfo.fieldList as fieldItem >
        <#if fieldItem.fieldClass == "Date">
            <#assign importDdate = true />
        </#if>
    </#list>
</#if>
import com.fun.common.web.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
<#if importDdate?? && importDdate>
import java.util.Date;
</#if>

/**
 * ${classInfo.classComment}
 *
 * @author DJun
 * @date ${.now?string('yyyy/MM/dd')}
 */
@Getter
@Setter
@ToString
public class ${classInfo.className} extends BaseEntity {
<#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
<#assign index=0 />
<#list classInfo.fieldList as fieldItem >
    /**
     * ${fieldItem.fieldComment}
     */
<#if fieldItem.fieldClass=='int' && index==0>
    private Long ${fieldItem.fieldName};
    <#assign index=1 />
<#else>
    private ${fieldItem.fieldClass} ${fieldItem.fieldName};
</#if>
</#list>
</#if>

}
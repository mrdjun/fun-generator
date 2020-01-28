<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.fun.project.mapper.${classInfo.className}Mapper">

    <resultMap id="${classInfo.className}Result" type="${classInfo.className}" >
    <#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
    <#list classInfo.fieldList as fieldItem >
        <result column="${fieldItem.columnName}" property="${fieldItem.fieldName}" />
    </#list>
    </#if>
    </resultMap>

    <sql id="${classInfo.className}ResultVo">
        select <#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0><#list classInfo.fieldList as fieldItem >${fieldItem.columnName}<#if fieldItem_has_next>,</#if></#list></#if> from ${classInfo.tableName}
    </sql>

    <select id="select${classInfo.className}ById" parameterType="Long" resultMap="${classInfo.className}Result">
       <include refid="${classInfo.className}ResultVo" />
        WHERE ${classInfo.primaryKey} = ${r"#{"}${classInfo.conversionPrimaryKey}${r"}"}
    </select>

    <select id="select${classInfo.className}List" parameterType="${classInfo.className}" resultMap="${classInfo.className}Result">
        <include refid="${classInfo.className}ResultVo"/>
        <where>

        </where>
    </select>

    <insert id="insert${classInfo.className}" parameterType="${classInfo.className}" useGeneratedKeys="true">
        INSERT INTO ${classInfo.tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
            <#list classInfo.fieldList as fieldItem >
                <#if fieldItem.columnName != "Id" >
                <if test="${fieldItem.fieldName} != null  and ${fieldItem.fieldName} != ''">${fieldItem.columnName}<#if fieldItem_has_next>,</#if> </if>
                </#if>
            </#list>
            </#if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#if classInfo.fieldList?exists && classInfo.fieldList?size gt 0>
            <#list classInfo.fieldList as fieldItem >
            <#if fieldItem.columnName != "Id" >
                <#if fieldItem.columnName="AddTime" || fieldItem.columnName="createTime" >
                NOW()<#if fieldItem_has_next>,</#if>
                <#else>
                <if test="${fieldItem.fieldName} != null  and ${fieldItem.fieldName} != ''">${r"#{"}${fieldItem.fieldName}${r"}"}<#if fieldItem_has_next>,</#if></if>
                </#if>
            </#if>
            </#list>
            </#if>
        </trim>
    </insert>

    <update id="update${classInfo.className}" parameterType="${classInfo.className}" >
        UPDATE ${classInfo.tableName}
        <trim prefix="SET" suffixOverrides=",">
            <#list classInfo.fieldList as fieldItem >
            <#if fieldItem.columnName != "Id" && fieldItem.columnName != "AddTime" && fieldItem.columnName != "UpdateTime" >
                <if test="${fieldItem.fieldName} != null  and ${fieldItem.fieldName} != ''">${fieldItem.columnName} = ${r"#{"}${fieldItem.fieldName}${r"}"}<#if fieldItem_has_next>,</#if></if>
            </#if>
            </#list>
        </trim>
        WHERE  ${classInfo.primaryKey} = ${r"#{"}${classInfo.conversionPrimaryKey}${r"}"}
    </update>

    <delete id="delete${classInfo.className}ById" parameterType="Long">
        DELETE FROM ${classInfo.tableName} WHERE  ${classInfo.primaryKey} = ${r"#{"}${classInfo.conversionPrimaryKey}${r"}"}
    </delete>

    <delete id="delete${classInfo.className}ByIds" parameterType="String">
        delete from ${classInfo.tableName} where ${classInfo.primaryKey} in
        <foreach item="item" collection="array" open="(" separator="," close=")">
            ${r"#{item}"}
        </foreach>
    </delete>

</mapper>

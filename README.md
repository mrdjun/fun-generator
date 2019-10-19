<h1 align="center"><a href="https://github.com/mrdjun" target="_blank">Fun-Generator</a></h1>
<p align="center">
<a href="https://github.com/mrdjun/fun-boot"><img alt="JDK" src="https://img.shields.io/badge/JDK-1.8-orange.svg"/></a>
<a href="http://mrdjun.github.io"><img alt="Author" src="https://img.shields.io/badge/Author-DJun-blue"/></a>
<a href="https://jq.qq.com/?_wv=1027&k=57LIuZr"><img alt="QQ群" src="https://img.shields.io/badge/chat-Coder%E5%A4%A7%E5%AE%B6%E5%BA%AD-yellow"/></a>
<a href="https://github.com/mrdjun/fun-generator/blob/master/LICENSE"><img alt="license" src="https://img.shields.io/github/license/java-aodeng/hope.svg?style=flat-square"/></a>
</p>

# 简介

> 🛠Powered By [xxl-code-generator](http://www.xuxueli.com/xxl-code-generator/#/). <br/>
> 🍋个人博客：mrdjun.github.io <br/>
> 🍊地址：https://github.com/mrdjun/fun-generator <br/>
------------------------------

## 项目说明
- 还在为不会写代码生成工具而发愁？可以利用此项目进行学习，还能直接用，足以满足小项目了，又快又狠。

- 目的：极大的增强代码生成工具的可移植性，快速完成小型外包项目，走到哪儿用到哪儿🍻

- 灵感源于 [xxl-code-generator](http://www.xuxueli.com/xxl-code-generator/#/).

- 可根据项目的需要，量身定制一套代码生成工具，虽然不能生成list.html、add.html、edit.html，可以根据自己的模板引擎和UI库在结合此示例，自行安排一套属于自己的代码生成工具。

- 如果你的项目是多模块的，你可以直接将 fun-generator 模块附加进去。

- 为什么不一次自动生成全部表的代码？

  <pre>
    <span  color=#2196F3 size=2 face="宋体">
  原因待我细细道来：
     ② 开箱即用！不用连接数据库!不用连接数据库!不用连接数据库!
     ① 我们在开发的过程中，大家都知道数据库都是难免会更改字段的，一般小公司是没有dba的，
  所以这个情况免不了🙃。一次生成一张表的代码，可以极大的降低耦合性与修改的不便性。就算
  修改单张表的字段后，即可针对这个马上重新生成代码来覆盖之前的代码。
     ③ 使用sql生成的原因是为了方便结合Flyway，使之更为便捷。
     </span>
  </pre>

## 使用说明
- 再三考虑了一下最终还是决定用聚合工程来搭建这个架子，其中包含三个模块
    - fun-demo 我放了一个生成的模板载里面作为参考，也可以将此模块作为测试模块使用。
    - fun-generator 生成器
    - tool-common 放的实体类和一些工具类

## 代码质量展示
### Controller
```java
 /**
  * 模板：查询【功能名】 列表
  * 查询 用户 列表
  */
 @PostMapping("/selectUserList")
 public CommonResult selectUserList(Demo demo,
                                    @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                    @RequestParam(value = "pageNum",defaultValue = "10",required = false)int pageSize){
     return CommonResult.success(CommonPage.restPage(userService.selectUserList(demo,pageNum,pageSize)));
 }

 /**
  * 模板：通过Id查询【功能名】
  * 通过Id查询 用户
  */
 @GetMapping("/selectUserById/{userId}")
 public CommonResult selectUserById(@PathVariable("userId") Long userId){
     return CommonResult.success(userService.selectUserById(userId));
 }

 /**
  * 模板：新增【功能名】
  * 新增 用户
  */
 @PostMapping("/insertUser")
 public CommonResult insertUser(Demo demo){
     return CommonResult.success(userService.insertUser(demo));
 }

 /**
  * 模板：修改【功能名】信息
  * 修改 用户 信息
  */
 @PostMapping("/updateUser")
 public CommonResult updateUser(Demo demo){
     return CommonResult.success(userService.updateUser(demo));
 }

 /**
  * 模板：通过id删除【功能名】
  * 通过id删除 用户
  */
 @GetMapping("/deleteUserById/{userId}")
 public CommonResult deleteUserById( @PathVariable("userId") Long userId){
     return CommonResult.success(userService.deleteUserById(userId));
 }

 /**
  * 模板：通过id批量删除【功能名】
  * 通过id 批量删除 用户
  */
 @PostMapping("/deleteUserByIds")
 public CommonResult deleteUserByIds(String userIds){
     return CommonResult.success(userService.deleteUserByIds(userIds));
 }
```

### MyBatis XML

```xml
<mapper namespace="com.fun.project.mapper.RoleMapper">
    <resultMap id="RoleResult" type="Role" >
        <result column="role_id" property="roleId" />
        <result column="role_name" property="roleName" />
        <result column="role_key" property="roleKey" />
        <result column="role_sort" property="roleSort" />
        <result column="status" property="status" />
        <result column="del_flag" property="delFlag" />
        <result column="create_by" property="createBy" />
        <result column="create_time" property="createTime" />
        <result column="update_by" property="updateBy" />
        <result column="update_time" property="updateTime" />
        <result column="remark" property="remark" />
    </resultMap>

    <sql id="RoleResultVo">
        select
        role_id,role_name,role_key,role_sort,status,del_flag,create_by,create_time,update_by,update_time,remark
         from sys_role
    </sql>

    <select id="selectRoleById" parameterType="Long" resultMap="RoleResult">
        <include refid="RoleResultVo" />
        WHERE role_id = #{roleId}
    </select>

    <select id="selectRoleList" parameterType="Role" resultMap="RoleResult">
        <include refid="RoleResultVo"/>
        <where>
            <if test="roleId != null and roleId != 0">
                and role_id = #{roleId}
            </if>
        </where>
    </select>

    <insert id="insertRole" parameterType="Role" useGeneratedKeys="true">
        INSERT INTO sys_role
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="roleId != null  and roleId != ''">role_id, </if>
            <if test="roleName != null  and roleName != ''">role_name, </if>
            <if test="roleKey != null  and roleKey != ''">role_key, </if>
            <if test="roleSort != null  and roleSort != ''">role_sort, </if>
            <if test="status != null  and status != ''">status, </if>
            <if test="delFlag != null  and delFlag != ''">del_flag, </if>
            <if test="createBy != null  and createBy != ''">create_by, </if>
            <if test="createTime != null  and createTime != ''">create_time, </if>
            <if test="updateBy != null  and updateBy != ''">update_by, </if>
            <if test="updateTime != null  and updateTime != ''">update_time, </if>
            <if test="remark != null  and remark != ''">remark </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="roleId != null  and roleId != ''">#{roleId},</if>
            <if test="roleName != null  and roleName != ''">#{roleName},</if>
            <if test="roleKey != null  and roleKey != ''">#{roleKey},</if>
            <if test="roleSort != null  and roleSort != ''">#{roleSort},</if>
            <if test="status != null  and status != ''">#{status},</if>
            <if test="delFlag != null  and delFlag != ''">#{delFlag},</if>
            <if test="createBy != null  and createBy != ''">#{createBy},</if>
            <if test="createTime != null  and createTime != ''">#{createTime},</if>
            <if test="updateBy != null  and updateBy != ''">#{updateBy},</if>
            <if test="updateTime != null  and updateTime != ''">#{updateTime},</if>
            <if test="remark != null  and remark != ''">#{remark}</if>
        </trim>
    </insert>

    <update id="updateRole" parameterType="Role" >
        UPDATE sys_role
        <trim prefix="SET" suffixOverrides=",">
            <if test="roleId != null  and roleId != ''">role_id = #{roleId},</if>
            <if test="roleName != null  and roleName != ''">role_name = #{roleName},</if>
            <if test="roleKey != null  and roleKey != ''">role_key = #{roleKey},</if>
            <if test="roleSort != null  and roleSort != ''">role_sort = #{roleSort},</if>
            <if test="status != null  and status != ''">status = #{status},</if>
            <if test="delFlag != null  and delFlag != ''">del_flag = #{delFlag},</if>
            <if test="createBy != null  and createBy != ''">create_by = #{createBy},</if>
            <if test="createTime != null  and createTime != ''">create_time = #{createTime},</if>
            <if test="updateBy != null  and updateBy != ''">update_by = #{updateBy},</if>
            <if test="updateTime != null  and updateTime != ''">update_time = #{updateTime},</if>
            <if test="remark != null  and remark != ''">remark = #{remark},</if>
        </trim>
        WHERE  role_id = #{roleId}
    </update>

    <delete id="deleteRoleById" parameterType="Long">
        DELETE FROM sys_role
        WHERE  role_id = #{roleId}
    </delete>

    <delete id="deleteRoleByIds" parameterType="String">
        delete from sys_role where role_id in
        <foreach item="item" collection="array" open="(" separator="," close=")">
            #{item}
        </foreach>
    </delete>
</mapper>
```
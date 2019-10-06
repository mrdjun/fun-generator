package com.fun.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

import com.fun.common.result.CommonResult;
import com.fun.project.entity.Role;
import com.fun.project.service.RoleService;
import com.fun.pagehelper.CommonPage;

import java.util.List;

/**
 * @author u-fun
 * @date 2019/10/06
 */
@Api("")
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation(" 查询Role列表")
    @PostMapping("/selectRoleList")
    @ResponseBody
    public CommonResult selectRoleList(Role role,
                                       @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                       @RequestParam(value = "pageNum",defaultValue = "10",required = false)int pageSize){
        List<Role> roles = roleService.selectRoleList(role,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(roles));
    }

    @ApiOperation("通过Id查询Role")
    @GetMapping("/selectRoleById/{roleId}")
    @ResponseBody
    public CommonResult selectRoleById(@PathVariable("roleId") Long roleId){
        return CommonResult.success(roleService.selectRoleById(roleId));
    }


    @ApiOperation("新增Role")
    @PostMapping("/insertRole")
    @ResponseBody
    public CommonResult insertRole(Role role){
        return CommonResult.success(roleService.insertRole(role));
    }


    @ApiOperation("修改Role信息")
    @PostMapping("/updateRole")
    @ResponseBody
    public CommonResult updateRole(Role role){
        return CommonResult.success(roleService.updateRole(role));
    }


    @ApiOperation("通过id删除Role")
    @PostMapping("/deleteRoleById/{roleId}")
    @ResponseBody
    public CommonResult deleteRoleById(@PathVariable("roleId") Long roleId){
        return CommonResult.success(roleService.deleteRoleById(roleId));
    }


    @ApiOperation("通过id批量删除Role")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult deleteRoleByIds(String roleIds){
        return CommonResult.success(roleService.deleteRoleByIds(roleIds));
    }
}

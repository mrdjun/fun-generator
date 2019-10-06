package com.fun.project.controller;


import com.fun.common.result.CommonResult;
import com.fun.project.entity.Demo;
import com.fun.project.service.IDemoService;
import com.fun.pagehelper.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author DJun
 */
@RestController
@RequestMapping("/user")
public class DemoController {
    @Autowired
    private IDemoService userService;

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

}

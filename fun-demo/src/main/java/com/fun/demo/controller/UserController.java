package com.fun.demo.controller;

import com.fun.demo.model.User;
import com.fun.demo.service.UserService;
import com.fun.demo.util.PageInfoEvt;
import com.github.pagehelper.PageInfo;
import com.fun.demo.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户信息")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("新增用户信息")
    @PostMapping("/insert")
    public R insert(User user){
        return userService.insert(user);
    }


    @ApiOperation("通过id删除用户信息")
    @PostMapping("/removeById/{userId}")
    public R removeById(@PathVariable("userId") Long userId){
        return userService.removeById(userId);
    }


    @ApiOperation("通过id批量删除用户信息")
    @PostMapping("/removeByIds")
    public R removeByIds(String userIds) {
        return userService.removeByIds(userIds);
    }


    @ApiOperation("修改用户信息")
    @PostMapping("/edit")
    public R edit(User user){
        return userService.edit(user);
    }

    @ApiOperation("通过Id查询用户信息")
    @PostMapping("/getById/{userId}")
    public R getById(Long userId){
        return R.success(userService.getById(userId));
    }


    @ApiOperation("查询用户信息列表")
    @PostMapping("/list")
    public R pageList(User user,PageInfoEvt evt) {
        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setList(userService.list(user, evt));
        return R.success(pageInfo);
    }

}

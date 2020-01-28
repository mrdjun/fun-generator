package com.fun.project.controller;

import com.fun.common.utils.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

import com.fun.common.result.CommonResult;
import com.fun.project.entity.User;
import com.fun.project.service.IUserService;
import com.fun.pagehelper.CommonPage;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.fun.common.result.CommonResult.failed;
import static com.fun.common.result.CommonResult.success;

/**
 * @author DJun
 * @date 2020/01/28
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public CommonResult login(User user) throws NoSuchAlgorithmException {
        if (StringUtils.isEmpty(user.getLoginName()) ||
                StringUtils.isEmpty(user.getPassword())) {
            return failed("账号或密码不能为空！");
        }

        User loginUser = userService.login(user);
        if (StringUtils.isNotNull(loginUser)) {
            return success(loginUser);
        }
        return failed("账号或密码错误！");
    }

    @ApiOperation("注册")
    @PostMapping("/regist")
    public CommonResult regist(User user) {
        int res = userService.checkLoginNameUnique(user.getLoginName());
        if (res > 0) {
            return failed("当前账号已存在");
        }
        user.setCreateBy("regist");
        return success(userService.insertUser(user));
    }

    @ApiOperation("查询用户列表")
    @PostMapping("/selectUserList")
    public CommonResult selectUserList(User user,
                                       @RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        List<User> users = userService.selectUserList(user, pageNum, pageSize);
        return success(CommonPage.restPage(users));
    }

    @ApiOperation("通过Id查询用户")
    @GetMapping("/selectUserById/{userId}")
    public CommonResult selectUserById(@PathVariable("userId") Long userId) {
        return success(userService.selectUserById(userId));
    }

    @ApiOperation("新增用户")
    @PostMapping("/insertUser")
    public CommonResult insertUser(User user) {
        return success(userService.insertUser(user));
    }


    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    public CommonResult updateUser(User user) {
        return success(userService.updateUser(user));
    }

    @ApiOperation("通过id删除用户")
    @PostMapping("/deleteUserById/{userId}")
    public CommonResult deleteUserById(@PathVariable("userId") Long userId) {
        return success(userService.deleteUserById(userId));
    }

    @ApiOperation("通过id批量删除用户")
    @PostMapping("/deleteList")
    public CommonResult deleteUserByIds(String userIds) {
        return success(userService.deleteUserByIds(userIds));
    }
}

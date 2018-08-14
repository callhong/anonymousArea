package com.rayclould.anonymousarea.web.controller;

import com.rayclould.anonymousarea.core.base.Result;
import com.rayclould.anonymousarea.core.constant.CodeConst;
import com.rayclould.anonymousarea.core.model.User;
import com.rayclould.anonymousarea.web.common.utils.CheckUtil;
import com.rayclould.anonymousarea.web.service.UserService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@RestController
@RequestMapping("user")
//@Api("mongodb測試-")
@Api(value = "/v1/users",tags = "Users",description = "用户接口V1")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value="获取用户信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result<User> get(@PathVariable("id") String id) {
        User user = userService.findById(id);
        return new Result<User>(user);
    }

    @ApiOperation(value="获取用户信息", notes = "根据url的花名来获取用户详细信息")
    @ApiImplicitParam(name = "stageName", value = "花名", required = true, dataType = "String")
    @RequestMapping(value = "getByStageName/{stageName}", method = RequestMethod.GET)
    public Result<User> getByStageName(@PathVariable("stageName") String stageName) {
        User user = userService.findByStageName(stageName);
        return new Result<User>(user);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(userService.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        return new Result<>(userService.add(user));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestBody User user) {
        Result result = new Result<>(CodeConst.PRIMARY_KEY_ISNULL.getResultCode(),CodeConst.PRIMARY_KEY_ISNULL.getMessage());
        if(CheckUtil.beforeUserUpdate(user)){
            result = new Result<>(userService.update(user));
        }
        return result;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        userService.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}

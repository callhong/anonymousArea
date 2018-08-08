package com.rayclould.anonymousarea.web.controller;

import com.rayclould.anonymousarea.core.base.Result;
import com.rayclould.anonymousarea.core.constant.CodeConst;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.utils.CheckUtil;
import com.rayclould.anonymousarea.web.service.PostService;
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
@RequestMapping("post")
//@Api("mongodb測試-")
@Api(value = "/v1/Posts",tags = "Posts",description = "帖子接口_V1")

public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ApiOperation(value="获取帖子信息", notes = "根据url的id来获取帖子详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result<Post> get(@PathVariable("id") String id) {
        Post post = postService.findById(id);
        return new Result<Post>(post);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(postService.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Post post) {
        return new Result<>(postService.add(post));
    }

    @ApiOperation(value="改变帖子状态", notes = "根据帖子的id来修改帖子状态信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(@RequestBody Post post) {
        Result result = new Result<>(CodeConst.PRIMARY_KEY_ISNULL.getResultCode(),CodeConst.PRIMARY_KEY_ISNULL.getMessage());
        if(CheckUtil.beforePostUpdate(post)){
            result = new Result<>(postService.update(post));
        }
        return result;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        postService.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }


}

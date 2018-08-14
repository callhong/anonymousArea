package com.rayclould.anonymousarea.web.controller;

import com.rayclould.anonymousarea.core.base.Result;
import com.rayclould.anonymousarea.core.constant.CodeConst;
import com.rayclould.anonymousarea.core.model.Comments;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.common.VO.InteractionVO;
import com.rayclould.anonymousarea.web.common.utils.CheckUtil;
import com.rayclould.anonymousarea.web.service.CommentsService;
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
@RequestMapping("comments")
@Api(value = "/v1/comments",tags = "Comments",description = "评论接口_V1")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @ApiOperation(value="获取单条评论", notes = "根据url的id来获取帖子详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path", dataType = "String")
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result<Comments> get(@PathVariable("id") String id) {
        Comments comment = commentsService.findById(id);
        return new Result<Comments>(comment);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(commentsService.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Comments comment) {
        return new Result<>(commentsService.add(comment));
    }

    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public Result deleteComments(@RequestBody Comments comment) {
        commentsService.deleteComment(comment);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

    @RequestMapping(value = "addComments", method = RequestMethod.POST)
    public Result addComments(@RequestBody Comments comment) {
        return new Result<>(commentsService.addComments(comment));
    }

    @RequestMapping(value = "replyComment", method = RequestMethod.POST)
    public Result replyComment(@RequestBody Comments comment) {
        return new Result<>(commentsService.replyComment(comment));
    }

    @RequestMapping(value = "replyToReplys", method = RequestMethod.POST)
    public Result replyToReplys(@RequestBody Comments comment) {
        return new Result<>(commentsService.replyToReplys(comment));
    }

    @ApiOperation(value="互动操作", notes = "oprType{<br />likesPost=帖子点赞<br /> forwardPost=转发帖子<br /> "
            +"likesComment=点赞评论<br /> likesReplyComment=点赞回复评论} <br /> incValue = 1 or -1")
    @RequestMapping(value = "interactionOpr", method = RequestMethod.POST)
    public Result interactionOpr(@RequestBody InteractionVO interactionVO) {
        Result result = new Result<>(CodeConst.PARAMETER_ERROR.getResultCode(),CodeConst.PARAMETER_ERROR.getMessage());
        if(CheckUtil.beforeInteractionOpr(interactionVO)){
            result = new Result<>(commentsService.interactionOpr(interactionVO));
        }
        return result;
    }
}

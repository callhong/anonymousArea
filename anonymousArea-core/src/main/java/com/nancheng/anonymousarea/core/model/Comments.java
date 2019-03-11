package com.nancheng.anonymousarea.core.model;

import com.nancheng.anonymousarea.core.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Comments", description = "评论对象")
public class Comments<T> extends BaseModel implements Serializable{

    @ApiModelProperty(value = "评论Id")
    private String commentId;

    @ApiModelProperty(value = "帖子Id")
    private String postId;

    @ApiModelProperty(value = "回复Id")
    private String replyId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String userPictures;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论图片")
    private List<String> imgUrl;

    @ApiModelProperty(value = "点赞数")
    private int likes;

    @ApiModelProperty(value = "回复")
    private T replys;

}

package com.rayclould.anonymousarea.core.model;

import com.rayclould.anonymousarea.core.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Post", description = "帖子对象")
public class Post<T> extends BaseModel implements Serializable{

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String userPictures;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "图片内容地址")
    private List<String> imgUrls;

    @ApiModelProperty(value = "点赞数")
    private int likes = 0;

    @ApiModelProperty(value = "转发数")
    private int forwardCount = 0;

    @ApiModelProperty(value = "状态： 0可见 1审核 2封禁 3删除")
    private int status;

    @ApiModelProperty(value = "评论")
    private T comments;

}

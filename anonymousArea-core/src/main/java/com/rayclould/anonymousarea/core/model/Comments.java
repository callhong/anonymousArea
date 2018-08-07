package com.rayclould.anonymousarea.core.model;

import com.rayclould.anonymousarea.core.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
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

    @ApiModelProperty(value = "用户Id")
    private String UserId;

    @ApiModelProperty(value = "用户名称")
    private String UserName;

    @ApiModelProperty(value = "评论内容")
    private Long content;

    @ApiModelProperty(value = "点赞数")
    private int Likes;

    @ApiModelProperty(value = "回复")
    private T data;

}

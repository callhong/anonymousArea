package com.nancheng.anonymousarea.web.common.vo;

import com.nancheng.anonymousarea.core.model.Comments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @Author: nanCheng
 * @Date: 2018/08/13
 */
@Data
public class InteractionVO extends Comments {

    @ApiModelProperty(value = "操作类型")
    private String oprType;

    @ApiModelProperty(value = "操作数值")
    private int incValue;
}

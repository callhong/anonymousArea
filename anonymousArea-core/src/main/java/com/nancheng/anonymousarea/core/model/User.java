package com.nancheng.anonymousarea.core.model;

import com.nancheng.anonymousarea.core.base.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User", description = "用户对象")
public class User extends BaseModel implements Serializable{

    @ApiModelProperty(value = "花名")
    private String stageName;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "性别：1男2女0保密")
    private int gender = 0;

    @ApiModelProperty(value = "电话")
    private Long phone = 0L;

    @ApiModelProperty(value = "图片地址")
    @Column(name = "img_url")
    private String imgUrl = "";

    @ApiModelProperty(value = "地址")
    private String address = "";

    @ApiModelProperty(value = "职业")
    private String profession = "";
}

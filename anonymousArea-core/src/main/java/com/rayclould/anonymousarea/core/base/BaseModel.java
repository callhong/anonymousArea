package com.rayclould.anonymousarea.core.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@MappedSuperclass
@Data
@ApiModel(value = "BaseModel", description = "基础模型")
public abstract class BaseModel implements Serializable {

    @Id
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime = new Date();
}

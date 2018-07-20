package com.raycloud.anonymousArea.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Author: hong
 * @Date: 2018/07/19
 */
@Data
public class User {
    @Id
    private String _id;
    private Integer userId;
    private String userName;
    private Integer companyId;
    private String company;


}

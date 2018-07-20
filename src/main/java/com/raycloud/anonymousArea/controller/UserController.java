package com.raycloud.anonymousArea.controller;

import com.raycloud.anonymousArea.domain.User;
import com.raycloud.anonymousArea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hong
 * @Date: 2018/07/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userService.getUser(userId);
    }
}

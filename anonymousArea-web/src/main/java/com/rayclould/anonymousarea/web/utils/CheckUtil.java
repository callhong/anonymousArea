package com.rayclould.anonymousarea.web.utils;

import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.core.model.User;

import java.util.Date;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */
public class CheckUtil {
    public static User beforeUserAdd(User user){
        user.setCreateTime(new Date());
        return user;
    }

    public static boolean beforeUserUpdate(User user){
        if(user.getId() != null && !"".equals(user.getId())){
            return true;
        }
        return false;
    }

    public static boolean beforePostUpdate(Post post){
        if(post.getId() != null && !"".equals(post.getId())){
            return true;
        }
        return false;
    }
}

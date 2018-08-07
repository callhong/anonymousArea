package com.rayclould.anonymousarea.web.common;

import com.rayclould.anonymousarea.core.base.Result;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.core.model.User;
import com.rayclould.anonymousarea.core.untils.IDUtil;

import java.util.Date;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */
public class CheckUtil {
    public static User beforeUserAdd(User user){
//        if(user.getId() == null || "".equals(user.getId())){
//            user.setId(IDUtil.getId());
//        }
        Date nowTime = new Date();
        user.setCreateTime(nowTime);
        user.setUpdateTime(nowTime);
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

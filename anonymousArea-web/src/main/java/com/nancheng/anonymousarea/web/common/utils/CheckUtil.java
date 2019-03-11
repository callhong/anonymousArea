package com.nancheng.anonymousarea.web.common.utils;


import com.nancheng.anonymousarea.core.constant.InteractionConst;
import com.nancheng.anonymousarea.core.model.Post;
import com.nancheng.anonymousarea.core.model.User;
import com.nancheng.anonymousarea.web.common.vo.InteractionVO;

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

    public static boolean beforeInteractionOpr(InteractionVO interactionVO){
        if(interactionVO.getPostId() == null && !"".equals(interactionVO.getPostId())){
            return false;
        }
        if(Math.abs(interactionVO.getIncValue()) != 1){
            return false;
        }
        boolean isTrueOprType = InteractionConst.LIKES_POST.equals(interactionVO.getOprType())
                || InteractionConst.FORWARD_POST.equals(interactionVO.getOprType())
                || InteractionConst.LIKES_COMMENT.equals(interactionVO.getOprType())
                || InteractionConst.LIKES_REPLY.equals(interactionVO.getOprType());
        return isTrueOprType;
    }
}

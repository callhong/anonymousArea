package com.rayclould.anonymousarea.web.service;


import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Comments;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.common.VO.InteractionVO;

import java.util.List;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

public interface CommentsService {

    /**
     * 查所有
     *
     * @return
     */
    List<Comments> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Comments findById(String id);


    /**
     * 添加
     *
     * @param comment
     * @return
     */
    Comments add(Comments comment);

    /**
     * 删除评论
     *
     * @param comment
     */
    void deleteComment(Comments comment);

    /**
     * 删除回复
     *
     * @param id
     */
    void deleteReplys(String id);

    /**
     *增加一条评论
     * @param comment
     * @return
     */
    UpdateResult addComments(Comments comment);

    /**
     * 回复评论
     * @param comment
     * @return
     */
    UpdateResult replyComment(Comments comment);

    /**
     * 回复别人的回复
     * @param comment
     * @return
     */
    UpdateResult replyToReplys(Comments comment);

    /**
     * 互动操作
     * @param interactionVO
     * @return
     */
    UpdateResult interactionOpr(InteractionVO interactionVO);

}

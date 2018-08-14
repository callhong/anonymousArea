package com.rayclould.anonymousarea.web.dao.repository;

import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Comments;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.common.VO.InteractionVO;
import org.springframework.stereotype.Repository;

/**
 * @Author: nanCheng
 * @Date: 2018/08/08
 */
@Repository
public interface CustomRepository{
    /**
     * 更新某些字段
     * @param post
     * @return
     */
    UpdateResult update(Post post);

    UpdateResult addComment(Comments comment);

    UpdateResult replyComment(Comments comment);

    UpdateResult replyToReplys(Comments comment);

    UpdateResult deleteComment(Comments comment);

    UpdateResult deleteReplyComment(Comments comment);

    UpdateResult interactionOpr(InteractionVO interactionVO);
}

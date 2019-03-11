package com.nancheng.anonymousarea.web.dao.repository;

import com.mongodb.client.result.UpdateResult;
import com.nancheng.anonymousarea.core.model.Comments;
import com.nancheng.anonymousarea.core.model.Post;
import com.nancheng.anonymousarea.web.common.vo.InteractionVO;
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

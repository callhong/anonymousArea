package com.nancheng.anonymousarea.web.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.nancheng.anonymousarea.core.model.Comments;
import com.nancheng.anonymousarea.core.untils.IDUtil;
import com.nancheng.anonymousarea.web.common.vo.InteractionVO;
import com.nancheng.anonymousarea.web.dao.CommentsDao;
import com.nancheng.anonymousarea.web.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private MongoRepository<Comments, String> mongoRepository;
    @Autowired
    public CommentsServiceImpl(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    @Override
    public List<Comments> findAll() {
        return commentsDao.findAll();
    }

    @Override
    public Comments findById(String id) {
        Optional<Comments> optionalComments = commentsDao.findById(id);
        return optionalComments.orElse(null);
    }


    @Override
    public Comments add(Comments comment) {
        comment.setCreateTime(comment.getUpdateTime());
        return commentsDao.save(comment);
    }

    @Override
    public void deleteComment(Comments comment) {
        commentsDao.deleteComment(comment);
    }

    @Override
    public void deleteReplys(String id) {

    }


    @Override
    public UpdateResult addComments(Comments comment) {
        comment.setCommentId(IDUtil.getId());
        comment.setCreateTime(comment.getUpdateTime());
        return commentsDao.addComment(comment);
    }

    @Override
    public UpdateResult replyComment(Comments comment) {
        comment.setCommentId(IDUtil.getId());
        comment.setCreateTime(comment.getUpdateTime());
        return commentsDao.replyComment(comment);
    }

    @Override
    public UpdateResult replyToReplys(Comments comment) {
        comment.setCommentId(IDUtil.getId());
        comment.setCreateTime(comment.getUpdateTime());
        return commentsDao.replyToReplys(comment);
    }

    @Override
    public UpdateResult interactionOpr(InteractionVO interactionVO) {
        return commentsDao.interactionOpr(interactionVO);
    }


}

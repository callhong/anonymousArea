package com.nancheng.anonymousarea.web.dao.repository.impl;

import com.mongodb.client.result.UpdateResult;
import com.nancheng.anonymousarea.core.constant.InteractionConst;
import com.nancheng.anonymousarea.core.model.Comments;
import com.nancheng.anonymousarea.core.model.Post;
import com.nancheng.anonymousarea.web.common.vo.InteractionVO;
import com.nancheng.anonymousarea.web.dao.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


/**
 * @Author: nanCheng
 * @Date: 2018/08/07
 */
@Component
public class CustomRepositoryImpl  implements CustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UpdateResult update(Post post) {
        Query query = new Query(Criteria.where("id").is(post.getId()));
        Update update = new Update().set("status",post.getStatus());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult addComment(Comments comment) {
        Query query = new Query(Criteria.where("id").is(comment.getPostId()));
        Update update = new Update();
        update.addToSet("comments",comment);
        UpdateResult writeResult = mongoTemplate.upsert(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult replyComment(Comments comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(comment.getPostId()));
        query.addCriteria(Criteria.where("comments.commentId").is(comment.getCommentId()));
        Update update = new Update();
        update.addToSet("comments.$.replys",comment);
        UpdateResult writeResult = mongoTemplate.upsert(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult replyToReplys(Comments comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(comment.getPostId()));
        query.addCriteria(Criteria.where("comments.replys.commentId").is(comment.getReplyId()));
        Update update = new Update();
        update.addToSet("comments.$.replys",comment);
        UpdateResult writeResult = mongoTemplate.upsert(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult deleteComment(Comments comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(comment.getPostId()));
        Criteria criteria = Criteria.where("id").is(comment.getPostId()).and("comments.commentId").is(comment.getCommentId());
        Update update = new Update();
        Field field = new Field();
        field.elemMatch("comments.$",criteria);
//        Aggregation agg = new Aggregation(
//                unwind("$userInfo"),
//                match(criteria),
//                project("apmInfo")
//        );
//        AggregationResults<Object> results = mongoTemplate.aggregate(agg, "APMInfo", Object.class);
//        List<Object> resultList = results.getMappedResults();

        update.pull("comments", comment.getCommentId());
//        update.unset("comments.$");
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult deleteReplyComment(Comments comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(comment.getPostId()));
        query.addCriteria(Criteria.where("comments.replys.commentId").is(comment.getCommentId()));
        Update update = new Update();
        update.pull("comments.$.replys",comment);
        UpdateResult writeResult = mongoTemplate.upsert(query, update, Post.class);
        return writeResult;
    }

    @Override
    public UpdateResult interactionOpr(InteractionVO interactionVO) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(interactionVO.getPostId()));
        Update update = new Update();
        String oprType = interactionVO.getOprType();
        int incValue = interactionVO.getIncValue();
        if(InteractionConst.LIKES_POST.equals(oprType)){
            update.inc("likes", incValue);
        }else if(InteractionConst.FORWARD_POST.equals(oprType)){
            update.inc("forwardCount", incValue);
        }else if(InteractionConst.LIKES_COMMENT.equals(oprType)){
            query.addCriteria(Criteria.where("comments.commentId").is(interactionVO.getCommentId()));
            update.inc("comments.$.likes", incValue);
        }
        //FIXME 二级内嵌无法使用两个占位符,更换另一种方法
        else if(InteractionConst.LIKES_REPLY.equals(oprType)){
            query.addCriteria(Criteria.where("comments.replys.commentId").is(interactionVO.getCommentId()));
            update.inc("comments.$.replys.$.likes", incValue);
        }
        UpdateResult writeResult = mongoTemplate.upsert(query, update, Post.class);
        return writeResult;
    }

}

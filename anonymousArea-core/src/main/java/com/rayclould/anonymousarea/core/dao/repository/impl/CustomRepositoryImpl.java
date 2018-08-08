package com.rayclould.anonymousarea.core.dao.repository.impl;

import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.dao.repository.CustomRepository;
import com.rayclould.anonymousarea.core.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


/**
 * @Author: nanCheng
 * @Date: 2018/08/07
 */
@Component
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UpdateResult update(Post post) {
        Query query = new Query(Criteria.where("id").is(post.getId()));
        Update update = new Update().set("status",post.getStatus());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, Post.class);
        return writeResult;
    }

}

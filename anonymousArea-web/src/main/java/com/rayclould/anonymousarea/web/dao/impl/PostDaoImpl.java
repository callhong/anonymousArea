package com.rayclould.anonymousarea.web.dao.impl;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


/**
 * @Author: nanCheng
 * @Date: 2018/08/07
 */
@Component
public abstract class PostDaoImpl  implements PostDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Post update(Post post) {
        Query query = new Query(Criteria.where("id").is(post.getId()));
        Update update = new Update().set("status",post.getStatus());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, Post.class);
        if(writeResult != null){
//            return writeResult.getModifiedCount();
        }
        return null;
    }

}

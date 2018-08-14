package com.rayclould.anonymousarea.web.dao;

import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Comments;
import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.dao.repository.CustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 **/

@Repository
public interface CommentsDao extends MongoRepository<Comments, String>, CustomRepository{

}

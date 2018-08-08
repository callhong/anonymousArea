package com.rayclould.anonymousarea.core.dao;

import com.rayclould.anonymousarea.core.dao.repository.CustomRepository;
import com.rayclould.anonymousarea.core.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 **/

@Repository
public interface PostDao extends MongoRepository<Post, String> {

    /**
     * 根据标题查帖子
     *
     * @param title
     * @return
     */
    Post findByTitle(String title);

}

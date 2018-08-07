package com.rayclould.anonymousarea.web.dao;

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



    /**
     * 更新某些字段
     * @param post
     * @return
     */
//    Post update(Post post);
}

package com.rayclould.anonymousarea.web.dao;

import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Post;

/**
 * @Author: nanCheng
 * @Date: 2018/08/08
 */
//@Repository
public interface CustomRepository {
    /**
     * 更新某些字段
     * @param post
     * @return
     */
    UpdateResult update(Post post);
}

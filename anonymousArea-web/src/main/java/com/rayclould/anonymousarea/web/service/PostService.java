package com.rayclould.anonymousarea.web.service;


import com.mongodb.client.result.UpdateResult;
import com.rayclould.anonymousarea.core.model.Post;


import java.util.List;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

public interface PostService {

    /**
     * 查所有
     *
     * @return
     */
    List<Post> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Post findById(String id);

    /**
     * 根据名字查
     *
     * @param title
     * @return
     */
    Post findByName(String title);

    /**
     * 添加
     *
     * @param post
     * @return
     */
    Post add(Post post);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     post
     * @param post
     * @return
     */
    UpdateResult update(Post post);

}

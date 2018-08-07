package com.rayclould.anonymousarea.web.service.impl;

import com.rayclould.anonymousarea.core.model.Post;
import com.rayclould.anonymousarea.web.dao.PostDao;
import com.rayclould.anonymousarea.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Service
public class PostServiceImpl implements PostService {
    private final PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Post findById(String id) {
        Optional<Post> optionalPost = postDao.findById(id);
        return optionalPost.orElse(null);
    }

    @Override
    public Post findByName(String title) {
        return postDao.findByTitle(title);
    }

    @Override
    public Post add(Post post) {
        post.setCreateTime(post.getUpdateTime());
        return postDao.save(post);
    }

    @Override
    public void delete(String id) {
        Optional<Post> optional = postDao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        postDao.delete(optional.get());
    }

    @Override
    public Post update(Post post) {
        return postDao.save(post);
    }
}

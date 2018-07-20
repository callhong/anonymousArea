package com.raycloud.anonymousArea.dao.impl;

import com.raycloud.anonymousArea.dao.UserDao;
import com.raycloud.anonymousArea.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hong
 * @Date: 2018/07/19
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{

    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    /**
     * 根据id得到对象
     */
    @Override
    public User getUser(Integer userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(userId)), User.class);
    }

    @Override
    public void update(User user) {
        Criteria criteria = Criteria.where("user_id").is(user.getUserId());
        Query query = new Query(criteria);
        Update update = Update.update("user_name",user.getUserName()).set("company", user.getCompany());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    @Override
    public void insertMany(List<User> users) {
        mongoTemplate.insertAll(users);
    }

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void remove(Integer userId) {
        Criteria criteria = Criteria.where("user_id").is(userId);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, User.class);
    }

    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        Query query = new Query();
        if (user != null && user.getUserName() != null) {
            //模糊查询
            query = new Query(Criteria.where("user_name").regex("^"+user.getUserName()));
        }
        List<User> users = mongoTemplate.find(query.with(pageable), User.class);
        return users;
    }
}

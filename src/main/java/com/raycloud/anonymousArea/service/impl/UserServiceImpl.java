package com.raycloud.anonymousArea.service.impl;

import com.raycloud.anonymousArea.dao.UserDao;
import com.raycloud.anonymousArea.domain.User;
import com.raycloud.anonymousArea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hong
 * @Date: 2018/07/19
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /**
     * 查找全部
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据id得到对象
     */
    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void insertMany(List<User> users) {
        userDao.insertMany(users);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void remove(Integer userId) {
        userDao.remove(userId);
    }

    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        return userDao.findByPage(user, pageable);
    }
}

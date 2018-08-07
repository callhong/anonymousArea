package com.rayclould.anonymousarea.web.service.impl;

import com.rayclould.anonymousarea.core.model.User;
import com.rayclould.anonymousarea.core.untils.IDUtil;
import com.rayclould.anonymousarea.web.common.CheckUtil;
import com.rayclould.anonymousarea.web.dao.UserDao;
import com.rayclould.anonymousarea.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userDao.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User findByStageName(String stageName) {
        return userDao.findByStageName(stageName);
    }

    @Override
    public User add(User user) {
        CheckUtil.beforeUserAdd(user);
        return userDao.insert(user);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optional = userDao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        userDao.delete(optional.get());
    }

    @Override
    public User update(User user) {
        return userDao.save(user);
    }
}

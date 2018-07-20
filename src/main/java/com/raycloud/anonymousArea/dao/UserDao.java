package com.raycloud.anonymousArea.dao;

import com.raycloud.anonymousArea.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: hong
 * @Date: 2018/07/19
 */
public interface UserDao {

    List<User> findAll();

    User getUser(Integer userId);

    void update(User user);

    void insert(User user);

    void insertMany(List<User> users);

    void remove(Integer userId);

    List<User> findByPage(User user, Pageable pageable);

}

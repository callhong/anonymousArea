package com.rayclould.anonymousarea.core.dao;

import com.rayclould.anonymousarea.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 * Description: 用户实体类
 **/

@Repository
public interface UserDao extends MongoRepository<User, Long> {

    /**
     * 根据字字查用户
     *
     * @param stageName
     * @return
     */
    User findByStageName(String stageName);

}

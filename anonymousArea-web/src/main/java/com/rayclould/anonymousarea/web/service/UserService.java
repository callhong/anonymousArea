package com.rayclould.anonymousarea.web.service;


import com.rayclould.anonymousarea.core.model.User;

import java.util.List;

/**
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

public interface UserService {

    /**
     * 查所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 根据名字查
     *
     * @param stageName
     * @return
     */
    User findByStageName(String stageName);

    /**
     * 添加
     *
     * @param user
     * @return
     */
    User add(User user);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     user
     * @param user
     * @return
     */
    User update(User user);

}

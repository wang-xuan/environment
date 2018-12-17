package com.itwx.environment.mybatis.cache.service;

import com.itwx.environment.mybatis.cache.model.User;

import java.util.List;

/**
 * @Author:wx
 * @Date:2018/12/14 13:32
 */
public interface UserService {
    List<User> getUserByState(Integer state);

    User getUserByName(String name);
}

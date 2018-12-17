package com.itwx.environment.mybatis.cache.service.impl;

import com.itwx.environment.mybatis.cache.mapper.UserMapper;
import com.itwx.environment.mybatis.cache.model.User;
import com.itwx.environment.mybatis.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wx
 * @Date:2018/12/14 13:32
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByState(Integer state) {
        log.info("=====>state:{}",state);
        return userMapper.selectUserByState(state);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.selectUserByName(name);
    }
}

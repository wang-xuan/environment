package com.itwx.environment.mybatis.cache.controller;

import com.itwx.environment.mybatis.cache.model.User;
import com.itwx.environment.mybatis.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:wx
 * @Date:2018/12/14 13:31
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 验证Integer类型条件值被过滤
     * @param state
     * @return
     */
    @GetMapping("/user/getUserByState")
    public List<User> getUserByState(Integer state){
        List<User> user = userService.getUserByState(state);
        return user;
    }

    /**
     * 不考虑存在重名的情况
     * 验证# ，$
     * @param name
     * @return
     */
    @GetMapping("/user/getUserByName")
    public User getUserByName(String name){
        User user = userService.getUserByName(name);
        return user;
    }

    /**
     * 动态sql使用@Param注解
     */

}

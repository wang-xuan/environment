package com.itwx.environment.mybatis.cache.mapper;

import com.itwx.environment.mybatis.cache.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:wx
 * @Date:2018/12/14 13:33
 */
@Mapper
public interface UserMapper {
    List<User> selectUserByState(@Param("state") Integer state);

    User selectUserByName(@Param("name") String name);
//    User selectUserByName( String name);
}

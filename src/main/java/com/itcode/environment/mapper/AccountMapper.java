package com.itcode.environment.mapper;

import com.itcode.environment.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author:wx
 * @Date:2019/11/21 15:45
 */
@Mapper
public interface AccountMapper {
    List<Account> selectAccount();
}

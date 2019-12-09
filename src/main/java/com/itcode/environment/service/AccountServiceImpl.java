package com.itcode.environment.service;

import com.itcode.environment.mapper.AccountMapper;
import com.itcode.environment.model.Account;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wx
 * @Date:2019/11/21 15:51
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAccount() {
        return accountMapper.selectAccount();
    }
}

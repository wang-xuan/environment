package com.itcode.environment.controller;

import com.itcode.environment.result.Result;
import com.itcode.environment.result.ResultGenerator;
import com.itcode.environment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:wx
 * @Date:2019/11/21 15:50
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getAccount")
    public Result getAccount() {
        return ResultGenerator.getSuccessResult(accountService.getAccount());
    }
}

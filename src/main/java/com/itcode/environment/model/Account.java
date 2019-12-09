package com.itcode.environment.model;

import java.math.BigDecimal;

/**
 * @Author:wx
 * @Date:2019/11/21 15:22
 */
public class Account {

    private String userName;
    private BigDecimal salary;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

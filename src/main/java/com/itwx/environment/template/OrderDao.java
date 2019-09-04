package com.itwx.environment.template;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author:wx
 * @Date:2019/9/4 11:18
 */

/**
 * 不使用注解注入Bean对象，则需要在Bean.xml中注册Bean
 */
public class OrderDao {
    /**注入JDBCTemplate模板对象,xml注入对象*/
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 减少小王的钱
     */
    public void reduceMoney() {
        String sql = "update account set salary = salary - ? where username = ?";
        jdbcTemplate.update(sql,10,"小王");
    }

    public void addMoney() {
        String sql  = "update account set salary = salary + ? where username = ?";
        jdbcTemplate.update(sql,10,"小马");
    }
}

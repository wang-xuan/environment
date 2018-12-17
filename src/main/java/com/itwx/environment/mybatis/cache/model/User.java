package com.itwx.environment.mybatis.cache.model;

/**
 * @Author:wx
 * @Date:2018/12/14 11:51
 */
public class User {
    private int id;
    private String name;
    private String blance;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlance() {
        return blance;
    }

    public void setBlance(String blance) {
        this.blance = blance;
    }
}

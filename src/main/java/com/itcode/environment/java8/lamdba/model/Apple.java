package com.itcode.environment.java8.lamdba.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author:wx
 * @Date:2019/9/29 16:57
 */
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(){

    }

    public Apple(String name) {
        this.name = name;
    }
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Apple(Apple apple) {
        this.name = apple.getName();
        this.id = apple.getId();
        this.money = apple.getMoney();
        this.num = apple.getNum();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 对于新建的对象，内容相同需要去除重复，ID和name相同的，则认为该对象相同
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(id, apple.id) &&
                Objects.equals(name, apple.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}

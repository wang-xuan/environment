package com.itcode.environment.java8.lamdba.model;

/**
 * @Author:wx
 * @Date:2019/10/11 10:52
 */
public class Dish {
    private String name;

    /**是否为素食：注意命名Boolean值不允许以isXXX*/
    private boolean vegetarian;
    /**卡路里*/
    private int calories;
    /**类型*/
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }
}

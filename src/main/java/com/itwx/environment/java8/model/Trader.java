package com.itwx.environment.java8.model;

/**
 * @Author:wx
 * @Date:2019/10/11 11:16
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}

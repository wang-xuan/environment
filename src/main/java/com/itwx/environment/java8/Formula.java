package com.itwx.environment.java8;

/**
 * @Author:wx
 * @Date:2019/8/29 15:28
 */
public interface Formula {

    double calculate(int a);
    /***/
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}

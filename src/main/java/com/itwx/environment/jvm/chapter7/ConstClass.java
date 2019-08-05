package com.itwx.environment.jvm.chapter7;

/**
 * @Author:wx
 * @Date:2019/6/19 16:38
 */
public class ConstClass {

    static{
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "Hello world";


}
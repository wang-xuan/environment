package com.itcode.environment.java8.funcation;

/**
 * @Author:wx
 * @Date:2019/11/7 15:16
 */
public class TestInterfaceImpl implements TestInterface {
    //实现类中不选择实现default类型的方法

    @Override
    public String normalMethod() {
        return "这是一个普通实现方法";
    }
}

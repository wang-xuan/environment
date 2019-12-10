package com.itcode.environment.java8.funcation;

/**
 * @Author:wx
 * @Date:2019/11/7 15:11
 */
public interface TestInterface {
     static void statisMethod(){
         System.out.println("接口中可以允许存在多个static类型的方法，但是子类或者实现类不能被重写");
     };

     default void defaultMethod() {
         System.out.println("接口中可以允许存在多个default类型的方法，但是子类或者实现类可以选择是否重写，不用加default关键字");
     }

     String normalMethod();
}

package com.itcode.environment.thread;

/**
 * @Author:wx
 * @Date:2019/11/12 15:11
 */
public class SynchronizedTest {

    public void syncBlock(){
        //修饰代码块
        synchronized (this){
            System.out.println("hello block");
        }
    }

    /**
     * synchronized修饰方法时，根据标志位进行加锁和释放锁
     */
    public synchronized void syncMethod(){
        System.out.println("hello method");
    }
}

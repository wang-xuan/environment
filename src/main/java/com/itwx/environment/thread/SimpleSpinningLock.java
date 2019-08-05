package com.itwx.environment.thread;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:wx
 * @Date:2019/6/24 10:14
 */
public class SimpleSpinningLock {

    private AtomicReference<Thread> ref = new AtomicReference<>();

    Optional<AtomicReference> optional = Optional.ofNullable(ref);

    public void lock(){
        Thread currentThread = Thread.currentThread();
        //compareAndSet()对对象为null时，返回true，否则为false
        //通过循环不断的自旋，判断锁是否被其他线程持有
        while(!ref.compareAndSet(null,currentThread)){

        }
    }

    public void unLock(){
        Thread cur = Thread.currentThread();
        if (ref.get() != cur){

        }
        ref.set(null);
    }

    public static void main(String[] args) {
    }
}

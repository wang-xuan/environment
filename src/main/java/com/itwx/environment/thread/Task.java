package com.itwx.environment.thread;

/**
 * @Author:wx
 * @Date:2019/10/30 9:22
 */
public class Task {

    /**
     * 实现Runnable接口实现线程
     */
    public static class TaskRunnable implements Runnable {
        private int i = 1;
        @Override
        public void run() {
            System.out.println("taskRunnable线程运行: " + i);
            i ++;
        }
    }

    /**
     * 继承Thread类实现线程
     */
    public static class TaskThread extends Thread {
        private int i = 1;
        @Override
        public void run() {
            System.out.println("taskThread线程运行: " + i);
            i ++;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========Runnable======");
        Runnable r1 = new TaskRunnable();
        Thread threadRunnable1 = new Thread(r1);
//        threadRunnable1.start();
        //run()如果不开启线程，就是相当于普通方法，按照顺序执行，只有主线程一个（main线程）
        threadRunnable1.run();

        //1、创建线程
        Runnable r2 = new TaskRunnable();
        Thread threadRunnable2 = new Thread(r2);
        //2、调用start()方法：线程为就绪态，并且会自动调用run方法
        threadRunnable2.start();
//        threadRunnable2.run();


        System.out.println("=========Thread========");
        TaskThread taskThread1 = new TaskThread();
//        taskThread1.start();
        taskThread1.run();

        TaskThread taskThread2 = new TaskThread();
        taskThread2.start();
        taskThread2.run();
    }
}

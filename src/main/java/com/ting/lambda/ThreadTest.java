package com.ting.lambda;

/**
 * 线程修改
 *
 * @author lishuang
 * @version 1.0
 * @date 2021/01/08
 */
public class ThreadTest {
    public static int num = 0;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
//        Thread thread = new Thread(ThreadTest::intAdd);
//        Thread thread1 = new Thread(ThreadTest::intAdd);
//        Thread thread2 = new Thread(ThreadTest::intAdd);
//        Thread thread3 = new Thread(ThreadTest::intAdd);
//        Thread thread4 = new Thread(ThreadTest::intAdd);
//        thread.start();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
    }


    public static void intAdd() {

        for (int i = 0; i < 1000; i++) {
            synchronized (ThreadTest.class) {
                System.out.println(Thread.currentThread().getName() + "------------->" + num++);
            }

        }

    }
}

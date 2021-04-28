package com.ting.lambda.hash;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/02/07
 */
public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("类重写--------------" + Thread.currentThread().getName());
        return 120;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer ss = new CallableTest()
                .call();
        System.out.println(ss);

        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        Future<Integer> name = threadPoolTest.threadPoolExecutor().submit(() -> {
            System.out.println("线程池--------------" + Thread.currentThread().getName());
            return 120;
        });
        System.out.println(name.get());
    }
}

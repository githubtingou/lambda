package com.ting.lambda.thread;

import java.util.concurrent.*;

/**
 * 线程测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/04/19
 */
public class CallableTest implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        return 125;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableTest callableTest = new CallableTest();
        Future<Integer> future = executorService.submit(callableTest);
        System.out.println("futureTask = " + future.get());

    }
}

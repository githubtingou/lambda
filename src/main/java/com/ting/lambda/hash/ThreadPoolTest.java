package com.ting.lambda.hash;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ting
 * @version 1.0
 * @date 2021/02/07
 */
public class ThreadPoolTest {
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ScheduledThreadPoolExecutor(10);
    }
}

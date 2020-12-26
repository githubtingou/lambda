package com.ting.lambda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleConsumer;

/**
 * DoubleConsumer学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/26
 */
public class DoubleConsumerLearn {
    public static void main(String[] args) {
        // Consumer 增强版

        List<String> list = new ArrayList<>();
        DoubleConsumer doubleConsumer = (param) -> list.add(String.valueOf(param * 10D));
        doubleConsumer.accept(10D);
        System.out.println("accept---->" + list);
        doubleConsumer.andThen((t) -> list.add(String.valueOf(t + 10)))
                .accept(10D);
        System.out.println("andThen---->" + list);

    }
}

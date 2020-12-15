package com.ting.lambda.consumer;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * BiConsumer学习
 *
 * @author lishuang
 * @version 1.0
 * @date 2020/12/15
 */
public class BiConsumerLearn {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> integerBiConsumer = (v1, v2) -> System.out.println(v1 + v2);
        integerBiConsumer.accept(10, 20);
        Map<Integer, String> map = new HashMap<>(10);
        map.put(10, "20");
        map.put(11, "20");
        map.put(13, "20");
        map.forEach((key, value) -> {
            System.out.println(key + "---" + value);
        });

    }

}

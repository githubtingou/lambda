package com.ting.lambda.consumer;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * BiConsumer学习
 *
 * @author ting
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
        integerBiConsumer.andThen((v1, v2) -> System.out.println(v1 * v2)).accept(10, 20);
        Stream<Integer> integerStream = map.keySet().stream();
        BigDecimal divide = BigDecimal.valueOf(10L).divide(BigDecimal.valueOf(2), 2);
        Integer integer = integerStream.findFirst().orElse(null);
        System.out.println(integer);

    }


}

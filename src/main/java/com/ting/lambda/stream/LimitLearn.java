package com.ting.lambda.stream;

import java.util.stream.IntStream;

/**
 * limit学习
 *
 * @author ting
 * @version 1.0
 * @date 2021/01/28
 */
public class LimitLearn {
    public static void main(String[] args) {
        IntStream.of(1, 2, 3, 4, 5, 6)
                .limit(1)
                .forEach(System.out::print);
    }
}

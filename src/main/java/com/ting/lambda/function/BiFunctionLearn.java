package com.ting.lambda.function;

import java.util.function.BiFunction;

/**
 * BiFunction学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/15
 */
public class BiFunctionLearn {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> biFunctionLearnInteger = (t, u) -> (t + 10) * u;
        System.out.println(biFunctionLearnInteger.apply(10, 20));

    }
}

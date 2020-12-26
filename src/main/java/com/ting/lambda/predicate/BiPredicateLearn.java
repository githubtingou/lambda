package com.ting.lambda.predicate;

import java.util.function.BiPredicate;

/**
 * Bipredicate学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/15
 */
public class BiPredicateLearn {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> biPredicate = (v1, v2) -> (v1 + 10) == v2;
        System.out.println(biPredicate.test(10, 20));
    }
}

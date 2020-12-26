package com.ting.lambda.function;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/24
 */
public class BinaryOperatorLearn {
    public static void main(String[] args) {
        // BinaryOperator : BiFunction的增强版，二元运算符

        // 取最大值
        System.out.println(BinaryOperator.maxBy(Integer::compareTo).apply(1, 2));
        // 取最小值
        System.out.println(BinaryOperator.minBy(Integer::compareTo).apply(1, 2));
    }
}

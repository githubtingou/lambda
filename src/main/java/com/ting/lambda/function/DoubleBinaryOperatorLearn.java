package com.ting.lambda.function;

import java.util.function.DoubleBinaryOperator;

/**
 * DoubleBinaryOperator学些
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/25
 */
public class DoubleBinaryOperatorLearn {
    public static void main(String[] args) {
        // function(BinaryOperator)增强版 ，数据类型为Double类型
        DoubleBinaryOperator doubleBinaryOperator = Double::sum;
        System.out.println(doubleBinaryOperator.applyAsDouble(10D, 20D));

        DoubleBinaryOperator doubleBinaryOperator1 = (left, right) -> left / right;
        System.out.println(doubleBinaryOperator1.applyAsDouble(100D, 20D));
    }
}

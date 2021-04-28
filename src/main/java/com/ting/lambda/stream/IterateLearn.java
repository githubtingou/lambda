package com.ting.lambda.stream;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * iterate无限流
 *
 * @author ting
 * @version 1.0
 * @date 2021/01/18
 */
public class IterateLearn {

    public static void main(String[] args) {

//        Stream.iterate("李四", i -> i + 1)
//                // 因为如果不加限制，会一直循环，此处加上limit进行限制，只进行10次循环
//                .limit(10)
//                .forEach(System.out::println);


        System.out.println("---" + Stream.iterate(BigDecimal.ZERO, big -> big.add(BigDecimal.ONE))
                .limit(10)
                .peek(System.out::println)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

}

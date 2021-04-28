package com.ting.lambda.predicate;

import java.util.function.BiPredicate;

/**
 * Predicate学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/14
 */
public class PredicateLearn {

    /**
     * predicate ：断言，主要是用来做判断使用
     * 返参为boolean类型
     */
    public static void main(String[] args) {

//        Predicate<Integer> predicateInteger = i -> i == 10;
//        System.out.println(predicateInteger.test(10));

//        Predicate<String> predicateString = "test"::equals;
//        System.out.println(predicateString.test("test"));
//
//        // and 俩个条件相等才会返回true
//        System.out.println("and且false--->" + predicateString.and(t -> t.contains("t")).test("test"));
//        System.out.println("and且false--->" + predicateString.and(t -> t.contains("t")).test("te"));
//
//        // 否定
//        Predicate<String> negate = predicateString.negate();
//        System.out.println("negate否true--->" + negate.test("tst"));
//        System.out.println("negate否false--->" + negate.test("test"));
//
//        // 或者
//        Predicate<Integer> predicateInteger1 = i -> i == 5;
//        System.out.println("or或者true--->" + predicateInteger.or(predicateInteger1).test(5));
//        System.out.println("or或者true--->" + predicateInteger.or(predicateInteger1).test(10));
//
//
//        // predicate接口默认包含方法
//        Predicate<String> predicateEqual = Predicate.isEqual("name");
//        System.out.println("isEqual包含true--->" + predicateEqual.test("name"));
//        System.out.println("isEqual包含false--->" + predicateEqual.test("nme"));
//        System.out.println("isEqual包含('')false--->" + predicateEqual.test(""));
//        System.out.println("isEqual包含(null)false--->" + predicateEqual.test(null));
//
//
        BiPredicate<String, String> biPredicate = PredicateLearn::test;
        System.out.println(biPredicate.test("name", "name"));

    }

    public static boolean test(String name, String name1) {

        return name.equals(name1);
    }


}

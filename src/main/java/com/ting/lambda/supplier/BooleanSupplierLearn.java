package com.ting.lambda.supplier;

import java.util.function.BooleanSupplier;

/**
 * @author ting
 * @version 1.0
 * @date 2020/12/24
 */
public class BooleanSupplierLearn {

    public static void main(String[] args) {
        // Supplier 增强版 ，判断条件是否相等，可以理解为if的判断条件
        int age = 10;
        int age1 = 100;
        BooleanSupplier booleanSupplier = () -> age == age1;
        System.out.println(booleanSupplier.getAsBoolean());

        System.out.println(isSuccess("赵四", "王五"));
        System.out.println(isSuccess("赵四1", "赵四1"));

    }

    public static boolean isSuccess(final String name, final String string) {
        BooleanSupplier booleanSupplier = () -> name.equals(string);
        return booleanSupplier.getAsBoolean();
    }

}

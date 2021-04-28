package com.ting.lambda.supplier;

import com.ting.lambda.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Supplier学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/15
 */
public class SupplierLearn {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        list.add(new User("李四", 18));
        //对象处理
        Supplier<User> supplier = User::new;
        Supplier<User> supplierAll = () -> list.get(0);
        System.out.println(supplier.get());
        System.out.println(supplierAll.get());
    }

}

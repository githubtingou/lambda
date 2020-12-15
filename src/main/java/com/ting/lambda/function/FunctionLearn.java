package com.ting.lambda.function;

import com.ting.lambda.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * function学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/11
 */
public class FunctionLearn {

    public static void main(String[] args) {
        /*
         *   function 函数接口
         *  主要用于不同类型转换；经典的就是Stream中的map方法
         *  只要将接口上有FunctionalInterface注解的都代表可以用lambda表达式表示
         *  Function<T, R>  泛型T代表的是的要转换的入参；R泛型是要输出的返参
         *
         *  andThen 执行顺序；先执行apply后执行andThen
         *
         * identity:返回自身
         * */

        Function<String,Integer> strToInt = Integer::parseInt;
        Integer apply = strToInt.apply("18");
        System.out.println(apply);


        Function<Integer, Integer> multiply10 = i -> {
            System.out.println("apply--i * 10;i=" + i);
            return i * 10;
        };

        Function<Integer, Integer> multiply100 = i -> {
            System.out.println("apply--i * 100;i=" + i);
            return i * 100;
        };

        System.out.println("andThen:start--------------------andThen:start");
        System.out.println(multiply10
                .andThen(multiply100)
                .apply(10));

        System.out.println("andThen:end--------------------compose:start");
        System.out.println(multiply10
                .compose(multiply100)
                .apply(10));

        List<User> list = new ArrayList<>();
        list.add(new User("李四", 20));
        list.add(new User("李四", 20));
        list.add(new User("李四1", 20));
        list.add(new User("李四2", 20));
        list.add(new User("李四3", 23));
        list.add(new User("李四4", 24));
        HashMap<User, List<User>> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.toList()));
        collect.forEach((k, v) -> System.out.println("identity---" + k + "+" + v));
        Map<Integer, List<User>> collect1 = list.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
        collect1.forEach((k, v) -> System.out.println("------------------" + k + "+" + v));
    }


}

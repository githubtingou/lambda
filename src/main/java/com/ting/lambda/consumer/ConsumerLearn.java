package com.ting.lambda.consumer;

import com.ting.lambda.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * consumer学习
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/15
 */
public class ConsumerLearn {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("李四", 18));
        list.add(new User("王五", 19));
        list.add(new User("赵大", 20));
        list.add(new User("钱二", 30));
        Consumer<List<User>> consumer = System.out::println;
        consumer.accept(list);


        // 未加强
        Consumer<List<User>> consumerSet = t -> t.forEach(t1 -> {
            if (t1.getName().equals("李四")) {
                t1.setName("李四未加强");
            }
        });
        consumerSet.accept(list);
        System.out.println("1--------------------------->");
        consumer.accept(list);


        // 加强
        Predicate<User> userPredicate = t -> t.getName().equals("李四未加强");
        Consumer<User> changeAge = t1 -> {
            if (userPredicate.test(t1)) {
                System.out.println("userPredicate李四加强--->");
                t1.setName("李四加强");
            }else {
                System.out.println("userPredicate李四加强No--->");
            }

        };
        Consumer<List<User>> consumerSet1 = t -> t.forEach(changeAge);
        consumerSet1.accept(list);
        System.out.println("2--------------------------->");
        consumer.accept(list);


        // andThen
        System.out.println("andThen--------------------------->");

        Consumer<List<User>> consumerSetNew = t -> t.forEach(t1 -> {
            if (t1.getName().equals("李四加强")) {
                System.out.println("consumerSetNew---------------");
                t1.setName("李四andThen");
            }
        });
        consumerSet1.andThen(System.out::println).andThen(consumerSetNew).accept(list);

    }
}


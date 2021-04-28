package com.ting.lambda.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/01/19
 */

public class Test {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
//        Queue<Integer> integers = new LinkedBlockingDeque<>(3);
//        integers.offer(1);
//        integers.offer(2);
//        integers.offer(3);
//        integers.offer(10);
//        System.out.println(Arrays.toString(integers.toArray()));
//        System.out.println(integers.peek());
//        System.out.println(Arrays.toString(integers.toArray()));
//        System.out.println(integers.poll());
//        System.out.println(Arrays.toString(integers.toArray()));

        System.out.println(ChronoUnit.MONTHS.between(LocalDate.now().plusMonths(-7), LocalDate.now()));
    }

}

package com.ting.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * lambda测试
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/11
 */
public class LambdaTest {


    public static void main(String[] args) {

        /*
         *  lambda表达式格式
         *  无参：()-{doSomething}
         *  单个参数：(param)->{doSomething} 或 param->{doSomething}
         *  俩个参数：(param1,param2)->{doSomething}
         *
         *
         *
         *
         * */
        // 1.7之前线程创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建");

            }
        }).start();

        // 1.8使用lambda线程创建
        // 无参
        new Thread(() -> System.out.println("线程创建-lambda")).start();

        // 单个参数
        Function<Integer, String> function = Object::toString;
        Function<Integer, String> function1 = Object::toString;


        // 俩个参数
        Map<Integer, String> map = new HashMap<>(6);
        map.put(1, "name");
        map.put(2, "age");
        map.put(3, "sex");
        map.forEach((key, value) -> System.out.println("key:" + key + "----value:" + value));

    }
}

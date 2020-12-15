package com.ting.lambda.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/14
 */
public class GenericTest {
    public static void main(String[] args) {
        Map<String, ? super Apple> map = new HashMap<>();
        map.put("FujiMountainApple", new FujiMountainApple());

        // 异常
//        list.add(new Fruit());

        Map<String, Class<? extends Fruit>> map1 = new HashMap<>();
        map1.put("Watermelon", Watermelon.class);
        map1.put("Apple", Apple.class);


    }
}

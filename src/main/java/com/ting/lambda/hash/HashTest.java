package com.ting.lambda.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * hash测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/02/01
 */
public class HashTest {
    Date date = new Date();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(10) {{
            add(10);
            add(11);
            add(12);
        }};

        List<Integer> copy = new ArrayList<Integer>(10) {{
            add(100);
            add(101);
            add(102);
            add(106);
            add(107);
            add(108);
            add(1089);
        }};
        list.addAll(1, copy);
        System.out.println(Arrays.toString(list.toArray()));
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(100);
            add(101);

        }};
        copy.removeAll(arrayList);
        System.out.println(Arrays.toString(copy.toArray()));

    }
}

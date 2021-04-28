package com.ting.lambda.service.impl;

import com.ting.lambda.dto.User;
import com.ting.lambda.service.ITestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 测试实现类
 *
 * @author ting
 * @version 1.0
 * @date 2021/03/02
 */
public class TestServiceImpl implements ITestService {
    /***
     * 获取用户名称
     * @param id 用户id
     * @return  {@link User}
     */
    @Override
    public Optional<User> getUser(String id) {

        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        long count = list.stream().filter(t -> t == 1).count();
        System.out.println(count);


    }

}




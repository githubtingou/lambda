package com.ting.lambda.service;

import com.sun.istack.internal.NotNull;
import com.ting.lambda.dto.User;

import java.util.Optional;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/03/02
 */
public interface ITestService {
    /***
     * 获取用户名称
     * @param id 用户id
     * @return  {@link User}
     */
    Optional<User> getUser(@NotNull String id);
}

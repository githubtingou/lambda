package com.ting.lambda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 用户
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Configuration
public class User {
    private String name;

    private Integer age;

    @Value("#user.name()")
    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Value("10")
    public void setAge(Integer age) {
        this.age = age;
    }

    public User getUser(User user) {
        return user;
    }

    public String name() {
        return "lisi";
    }


}







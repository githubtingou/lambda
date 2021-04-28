package com.ting.lambda.controller;

import com.ting.lambda.anno.AopTest;
import com.ting.lambda.dto.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/02/08
 */
@RestController
@RequestMapping(value = "/url")
public class TestUrlController {

    @PostMapping(value = "/test/{urlName}")
    @AopTest
    public String name(@PathVariable String urlName, @RequestBody User user) {

        return "name";
    }

    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String name1(@RequestBody Object obj) {

        return "success";
    }


}

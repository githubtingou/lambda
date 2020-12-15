package com.ting.lambda.generic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 苹果
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/14
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Apple extends Fruit {
    /**
     * 颜色
     */
    private String color;
}

package com.ting.lambda.generic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 富士山苹果
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/14
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class FujiMountainApple extends Apple {

    /**
     * 产地
     */
    private String place;
}

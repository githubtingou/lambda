package com.ting.lambda.anno;

import java.lang.annotation.*;

/**
 * 测试aop顺序
 *
 * @author ting
 * @version 1.0
 * @date 2021/04/12
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopTest {

    String value() default "";

}

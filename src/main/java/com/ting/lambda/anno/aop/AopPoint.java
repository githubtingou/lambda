package com.ting.lambda.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 顺序 --
 *
 * <ul>
 * <li>环绕通知（在调用joinPoint.proceed()之前）<li/>
 * <li>前置通知<li/>
 * <li>后置通知<li/>
 * <li>环绕通知（在调用joinPoint.proceed()之后）<li/>
 * </ul>
 *
 * @author ting
 * @version 1.0
 * @date 2021/04/12
 */
@Aspect
@Component
public class AopPoint {

    @Pointcut("@annotation(com.ting.lambda.anno.AopTest)")
    public void point() {
        // 切点
    }

    @Before("point()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before----------------");
    }

    @After("point()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after----------------");
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around----------------start");
        Object proceed = joinPoint.proceed();
        System.out.println("Around----------------end");
        return proceed;
    }
}

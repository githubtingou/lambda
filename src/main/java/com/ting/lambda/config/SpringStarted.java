//package com.ting.lambda.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//
///**
// * spring启动后执行方法
// *
// * @author ting
// * @version 1.0
// * @date 2021/02/05
// */
//@Component
//@Slf4j
//public class SpringStarted implements ApplicationListener<ApplicationStartedEvent> {
//    /**
//     * Handle an application event.
//     *
//     * @param event the event to respond to
//     */
//    @Override
//    public void onApplicationEvent(ApplicationStartedEvent event) {
//        System.out.println("启动后执行");
//    }
//
////    public static void main(String[] args) {
////        System.out.println(hash("123456"));
////        System.out.println(1 >>> 16);
////        System.out.println(1450594325 ^ 22134);
////    }
//
//    static int hash(Object key) {
//        int h;
//        System.out.println(key.hashCode());
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    public static void main(String[] args) {
//
//        LocalDate startDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse("2020-10-01"));
//        System.out.println(startDate.getYear());
//        System.out.println(startDate.getMonth());
//        System.out.println(startDate.getDayOfYear());
//        System.out.println(startDate.toEpochDay());
//        System.out.println(LocalDate.now().toEpochDay() - startDate.toEpochDay());
//        System.out.println(ChronoUnit.MONTHS
//                .between(startDate, LocalDate.now()));
//
//        System.out.println(ChronoUnit.DAYS
//                .between(startDate, LocalDate.now()));
//
//    }
//
//
//}
//

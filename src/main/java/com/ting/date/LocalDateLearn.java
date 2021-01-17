package com.ting.date;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 1.8新特性=时间处理
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/26
 */
@Slf4j
public class LocalDateLearn {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        log.info("日期年月日：{}：", now);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString()
                .replaceAll("T", " "));
        System.out.println(localDateTime);
        System.out.println(localDateTime.getMonth());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(dateTimeFormatter));

    }
}

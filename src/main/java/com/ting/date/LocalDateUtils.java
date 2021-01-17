package com.ting.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * jdk1.8新特性时间工具类
 *
 * @author ting
 * @version 1.0
 * @date 2020/12/26
 */
public class LocalDateUtils {

    /**
     * 时间格式为：yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据LocalDateTime返回 yyyy-MM-dd HH:mm:ss格式的时间
     *
     * @param localDateTime {@link LocalDateTime} 时间
     * @return yyyy-MM-dd HH:mm:ss
     * @see DateTimeFormatter#ofPattern(String)
     */
    public static String getTime(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static String getDate(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}

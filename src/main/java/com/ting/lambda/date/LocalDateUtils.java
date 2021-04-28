package com.ting.lambda.date;

import java.time.LocalDate;
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
     * 获取时间,格式yyyy-MM-dd HH:mm:ss
     * <p>
     * 例：2021-01-28 13:42:39
     *
     * @param localDateTime {@link LocalDateTime} 时间
     * @return yyyy-MM-dd HH:mm:ss
     * @see DateTimeFormatter#ofPattern(String)
     */
    public static String getTime(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    /**
     * 获取当前时间,格式yyyy-MM-dd HH:mm:ss
     * <p>
     * 例：2021-01-28 13:42:39
     *
     * @return yyyy-MM-dd HH:mm:ss
     * @see DateTimeFormatter#ofPattern(String)
     */
    public static String getTime() {
        return LocalDate.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * 格式时间，格式yyyyMMdd
     * <p>
     * 例：20210128
     *
     * @param localDateTime {@link LocalDateTime} 时间
     * @return yyyyMMdd
     */
    public static String getDate(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
    }


    /**
     * 根据传入的格式返回时间
     *
     * @param localDateTime {@link LocalDateTime} 时间
     * @param formatter     {@link DateTimeFormatter} 时间格式
     * @return 格式化的时间
     */
    public static String getDateByFormatter(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return localDateTime.format(formatter);
    }

    /**
     * 根据传入的格式返回当前时间
     *
     * @param formatter {@link DateTimeFormatter} 时间格式
     * @return 格式化的时间
     */
    public static String getDateByFormatter(DateTimeFormatter formatter) {
        return LocalDateTime.now().format(formatter);
    }


    /**
     * 获取俩个时间的相隔天数
     *
     * @return
     */
    public static Integer getBetweenTimes(LocalDate first, LocalDate last) {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}

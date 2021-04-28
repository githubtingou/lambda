package com.ting.lambda.date.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期工具类
 *
 * @author ting
 * @version 1.0
 * @date 2021/03/17
 */
public class LocalDateUtils {

    public static void getAllDateByPreYears() {
        long start = System.currentTimeMillis();
        getAllDateByYears(DateTimeFormatter.ofPattern("yyyy-MM-dd"), 1);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void getAllDateByYears(DateTimeFormatter formatter, long years) {
        LocalDate date = LocalDate.now()
                .plusYears(years);
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfYear());
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("firstDay:" + firstDay.format(formatter));
        System.out.println("lastDay:" + lastDay.format(formatter));
        while (firstDay.compareTo(lastDay) <= 0) {
            switch (firstDay.getDayOfWeek().name()) {
                case "MONDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "一");
                    break;
                case "TUESDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "二");
                    break;
                case "WEDNESDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "三");
                    break;
                case "THURSDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "四");
                    break;
                case "FRIDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "五");
                    break;
                case "SATURDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "六");
                    break;
                case "SUNDAY":
                    System.out.println("day= " + firstDay.format(formatter) + "----星期" + "日");
                    break;
                default:
                    System.out.println("没有匹配到周期");
                    break;

            }
            firstDay = firstDay.plusDays(1);
        }
    }

    public static void main(String[] args) {
        getAllDateByPreYears();
    }
}

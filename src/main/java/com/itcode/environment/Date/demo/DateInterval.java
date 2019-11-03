package com.itcode.environment.Date.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:wx
 * @Date:2019/6/19 14:37
 */
public class DateInterval {

    /**
     * 将时间转化成毫秒计算，日期间隔
     */
//    public static int dayDistance(Date startDate, Date endDate){
//        int day = (int)( endDate.getTime()-startDate.getTime())/(1000*3600*24);
//        return Math.abs(day);
//    }
//
//    public static void main(String[] args) throws ParseException {
//        String startDate = "2019-04-24";
//        String endDate = "2019-04-09";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        int dayDistance = dayDistance(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate));
//        System.out.println("日期间差:"+dayDistance);
//
//    }

    public static String getAgeByBirth(Date birthDay) {
        Calendar birthCalender = Calendar.getInstance();
        birthCalender.setTime(birthDay);
        Calendar nowCalender = Calendar.getInstance();
        Date nowTime = new Date();
        nowCalender.setTime(nowTime);
        int birthYear = birthCalender.get(Calendar.YEAR);
        int nowYear = nowCalender.get(Calendar.YEAR);
        //年份差
        int year = nowYear - birthYear;
        if (year < 1) {
            //小于1年，返回天
            int day = (int) Math.abs((nowTime.getTime() - birthDay.getTime()) / (1000 * 3600 * 24));
            return day + "天";
        } else if (year >= 1 && year < 3) {
            //1-3年，返回月
            int birthMonth = birthCalender.get(Calendar.MONTH);
            int nowMonth = nowCalender.get(Calendar.MONTH);
            int month = year * 12 + nowMonth - birthMonth;
            return month + "月";
        } else {
            return year + "岁";
        }
    }

    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthDay = dateFormat.parse("2019-08-02");
            String age = getAgeByBirth(birthDay);
            System.out.println(age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

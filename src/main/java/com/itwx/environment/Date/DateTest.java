package com.itwx.environment.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 * @Author:wx
 * @Date:2019/6/19 14:37
 */
public class DateTest {

    /**
     * 将时间转化成毫秒计算，日期间隔
     * */
    public static int dayDistance(Date startDate, Date endDate){
        int day = (int) (endDate.getTime()-startDate.getTime())/(1000*3600*24);
        return day;
    }

    public static void main(String[] args) throws ParseException {
        String startDate = "2019-03-24";
        String endDate = "2019-04-09";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int dayDistance = dayDistance(simpleDateFormat.parse(startDate), simpleDateFormat.parse(endDate));
        System.out.println("日期间差:"+dayDistance);

    }
}

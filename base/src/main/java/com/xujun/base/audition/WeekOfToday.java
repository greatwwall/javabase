package com.xujun.base.audition;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
  * @todo 获取当前日期是星期几
  * @author xujun
  * @version 1.0
  * @date 2018年4月14日 下午8:51:19 
  */

public class WeekOfToday {

    public static String getWeekDay(Date date) {
        // 星期天排第一
        String[] weekDays = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static String getWeekDay2(Date date){
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }
    
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(getWeekDay(date));
        System.out.println("---------------");
        System.out.println(getWeekDay2(date));
    }
}

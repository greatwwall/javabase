package com.xujun.base.audition;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
  * @todo 获取两位小数
  * @author xujun
  * @version 1.0
  * @date 2018年4月14日 下午9:08:06 
  */

public class TwoDecimal {

    // 直接打印
    public static void test1(double d) {
        System.out.println(String.format("%.2f", d));
    }

    // 使用小数格式化类
    public static void test2(double d) {
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println(format.format(d));
    }

    // 使用数字格式化类
    public static void test3(double d) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        System.out.println(format.format(d));
    }

    // 使用bigdecimal类
    public static void test4(double d) {
        BigDecimal bg = new BigDecimal(d);
        double f = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f);
    }

    public static void main(String[] args) {
        double d = 3.1415726;
        test1(d);
        test2(d);
        test3(d);
        test4(d);
    }
}

package com.xujun.base.audition;

/**
  * @todo 不通过第三方变量替换两个int的值
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午8:45:57 
  */

public class ExchangeIntValueWithoutThreadVar {

    public static void exchange1(int m, int n) {
        m = m - n;
        System.out.println("m = " + m + ", n = " + n);
        n = n + m;
        System.out.println("m = " + m + ", n = " + n);
        m = n - m;
        System.out.println("m = " + m + ", n = " + n);
    }

    public static void exchange2(int m, int n) {
        m = m ^ n;
        System.out.println("m = " + m + ", n = " + n);
        n = n ^ m;
        System.out.println("m = " + m + ", n = " + n);
        m = n ^ m;
        System.out.println("m = " + m + ", n = " + n);
    }

    public static void main(String[] args) {
        exchange1(15, 4);
        exchange2(15, 4);
    }
}

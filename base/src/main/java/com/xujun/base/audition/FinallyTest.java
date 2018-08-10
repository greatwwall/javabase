package com.xujun.base.audition;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年8月10日 下午9:37:57 
  */

public class FinallyTest {

    public static void main(String[] args) {
        int a = 5;
        try {
            System.out.println("a value is : - " + ((a < 5) ? 9.9 : 3));
            int b = a / 0;
            System.out.println("c");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("a");
        } finally {
            Thread thread = Thread.currentThread();
            System.out.println("b");
            System.out.println(a == 5);
            System.out.println(thread);
        }
    }
}

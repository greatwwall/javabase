package com.xujun.base.keywords.kwhile;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午4:48:53 
  */

public class WhileTest {

    public static void test1(int i) {
        while (0 < i) {
            i--;
            System.out.println(i);
        }
    }

    public static void test2(int i) {
        do {
            i--;
            System.out.println(i);
        } while (0 < i);
    }

    public static void main(String[] args) {
        test1(5);
        test2(5);
    }
}

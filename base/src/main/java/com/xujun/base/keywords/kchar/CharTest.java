package com.xujun.base.keywords.kchar;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午4:56:29 
  */

public class CharTest {

    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);// a
        a = '中';
        System.out.println(a);// 中
        a = 98;
        System.out.println(a);// b, 98对应b
        a = 'a' + 1;
        System.out.println(a);// b
    }
}

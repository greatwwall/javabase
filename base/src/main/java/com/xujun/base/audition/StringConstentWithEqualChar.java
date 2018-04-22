package com.xujun.base.audition;

import java.util.Arrays;

/**
  * @todo 判断两个字符串是否由相同的字符组成
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午9:45:25 
  */

public class StringConstentWithEqualChar {

    public static boolean test(String s1, String s2) {
        byte[] ch1 = s1.getBytes();
        byte[] ch2 = s2.getBytes();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if (ch1.length != ch2.length) {
            return false;
        }
        for (int i = 0; i < ch2.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "bcedfa";
        System.out.println(test(s1, s2));
    }
}

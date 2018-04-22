package com.xujun.base.audition;

/**
  * @todo 字符串反转
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午9:21:53 
  */

public class ReverseString {

    public static String reverse1(String str) {
        if (str.length() == 1)
            return str;
        System.out.println(str);
        return reverse1(str.substring(1)) + str.charAt(0);
    }

    public static String reverse2(String str) {
        int length = str.length();
        char[] ch = str.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            char temp = ch[i];
            ch[i] = ch[length - i - 1];
            ch[length - i - 1] = temp;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(reverse1(s));
        System.out.println("---------");
        System.out.println(reverse2(s));
    }
}

package com.xujun.base.audition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  * @todo 检查一个字符串是否只包含整数
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午8:12:41 
  */

public class StringOnlyContainsInt {

    public static boolean judge(String str) {
        String regex = "\\d.*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        int k = 0;
        if (m.find()) {
            System.out.println(m.group());
            k = m.group().length();
        }
        System.out.println(k == str.length());
        return k == str.length();
    }

    public static void main(String[] args) {
        judge("abcde12345");
        judge("5934812345");
    }
}

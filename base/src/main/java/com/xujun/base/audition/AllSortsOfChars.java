package com.xujun.base.audition;

import java.util.HashSet;
import java.util.Set;

/**
  * @todo 打印一个字符串的所有排列
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午10:38:53 
  */

public class AllSortsOfChars {

    private static Set<String> set = new HashSet<String>();

    private static void test(int k, char[] ch) {
        // 最后一个字符无需交换,交换结束
        if (k == ch.length - 1) {
            System.out.println("++" + String.valueOf(ch));
            set.add(String.valueOf(ch));
        }
        char temp = ' ';
        for (int i = k; i < ch.length; i++) {
            temp = ch[i];
            ch[i] = ch[k];
            ch[k] = temp;
            test(k + 1, ch);
            temp = ch[i];
            ch[i] = ch[k];
            ch[k] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        test(0, s.toCharArray());
        System.out.println(set.size());
        for (String string : set) {
            System.out.println(string);
        }
    }

}

package com.xujun.base.keywords.kfinal;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月7日 下午3:45:05
 */

public class FinalStringJoin {

    public static void main(String[] args) {
        String str1 = "final string";
        String str2 = "final " + "string";
        System.out.println(str1 == str2);// true

        String str3 = "final ";
        String str4 = "string";
        String str5 = str3 + str4;
        System.out.println(str1 == str5);// false,因为转成指令后str5不是一个字符串,而是两个变量相加

        final String str6 = "final ";
        final String str7 = "string";
        String str8 = str6 + str7;
        System.out.println(str1 == str8);// true,加了final之后str8是一个字符串,因为在编译时可以确定str6,str7的值
    }
}

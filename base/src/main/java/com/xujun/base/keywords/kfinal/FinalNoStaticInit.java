package com.xujun.base.keywords.kfinal;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月7日 下午3:55:02
 */

public class FinalNoStaticInit {

    final String str1;
    final String str2;
    final String str3 = "java";

    {
        str1 = "java";
    }

    public FinalNoStaticInit() {
        str2 = "java";
    }

    public void compare() {
        System.out.println(str1 + str1 == "javajava");// false, final不会对初始空变量替换为赋值的值
        System.out.println(str2 + str2 == "javajava");// false
        System.out.println(str3 + str3 == "javajava");// true, final修饰的一开始就有赋值的变量,会直接替换为赋值的值
    }

    public static void main(String[] args) {
        FinalNoStaticInit fnsi = new FinalNoStaticInit();
        fnsi.compare();
    }
}

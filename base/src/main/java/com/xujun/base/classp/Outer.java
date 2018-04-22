package com.xujun.base.classp;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 上午11:28:45
 */

public class Outer {

    public void print(final String a) {
        class Inner {
            public void function() {
                System.out.println(a);
            }
        }
        // 报错,jdk1.8如果局部变量不赋值,默认是final的,与1.7的不同,放开注释会报错
        // a = "hello";
        new Inner().function();
    }

    public static void main(String[] args) {
        new Outer().print("world");
    }
}

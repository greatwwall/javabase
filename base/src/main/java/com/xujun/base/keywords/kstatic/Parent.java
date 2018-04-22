package com.xujun.base.keywords.kstatic;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 上午11:09:14
 */

public class Parent {

    private Person person = new Person("parent成员变量");
    private static Person person2 = new Person("parent静态成员变量");

    static {
        System.out.println("parent静态块");
    }

    public Parent() {
        System.out.println("parent构造器");
    }

    public static void test() {
        System.out.println("parent静态方法");
    }

}

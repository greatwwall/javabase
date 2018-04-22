package com.xujun.base.keywords.kstatic;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 上午11:12:33
 */

public class Son extends Parent {

    static {
        System.out.println("son静态块");
    }
    private static Person person2 = new Person("son静态成员变量");

    public Son() {
        System.out.println("son构造器");
    }

    private Person person = new Person("son成员变量");

    public static void test() {
        System.out.println("son静态方法");
    }
}

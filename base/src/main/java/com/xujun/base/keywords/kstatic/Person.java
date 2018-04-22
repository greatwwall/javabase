package com.xujun.base.keywords.kstatic;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 上午11:11:10
 */

public class Person {
    static {
        System.out.println("person静态块");
    }

    public Person(String name) {
        System.out.println(name);
    }
}

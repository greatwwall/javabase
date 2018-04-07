package com.xujun.base.function.clone;

import java.io.IOException;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月5日 下午3:48:46
 */

public class CloneUtilTest {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Person person = new Person("shanren", new Car("BYD"));
        Person person2 = CloneUtil.clone(person);
        System.out.println(person2);
        person2.getCar().setName("haval");;
        System.out.println(person2);
        System.out.println(person);
    }
}

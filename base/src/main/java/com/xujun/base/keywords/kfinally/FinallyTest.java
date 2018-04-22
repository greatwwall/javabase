package com.xujun.base.keywords.kfinally;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午4:12:59 
  */

public class FinallyTest {

    // try block
    // finally block
    // 说明finally在try的return之前执行
    public static void execute() {
        try {
            System.out.println("try block");
            return;
        } finally {
            System.out.println("finally block");
        }
    }

    // try block
    // catch block
    // finally block
    // 说明finally在catch的return之前执行
    public static void execute2() {
        try {
            System.out.println("try block");
            int i = 1 / 0;
            return;
        } catch (Exception e) {
            System.out.println("catch block");
            return;
        } finally {
            System.out.println("finally block");
        }
    }

    // try k : 1
    // finally k : 2
    // getValue() : 1
    // finally块实在try的return之前执行的,为什么getValue()不是2
    // 因为在执行finally之前会将try的值保存到本地变量表,return的时候会从本地变量表中取出保留值到
    // 当前操作数栈中, return的当前栈中的值
    public static int getValue() {
        int k = 1;
        try {
            System.out.println("try k : " + k);
            return k;
        } finally {
            k++;
            System.out.println("finally k : " + k);
        }
    }

    // getValue2() : 5
    @SuppressWarnings("finally")
    public static int getValue2() {
        int k = 1;
        try {
            k = 4;
        } finally {
            k++;
            return k;
        }
    }

    // getValue3() : 5
    public static int getValue3() {
        int k = 1;
        try {
            k = 4;
        } finally {
            k++;
        }
        return k;
    }

    // try block
    // test block
    // finally block
    // getValue4() : test return
    public static String getValue4() {
        try {
            System.out.println("try block");
            // 相当于 String temp = test();
            // return temp;
            return test();
        } finally {
            System.out.println("finally block");
        }
    }

    private static String test() {
        System.out.println("test block");
        return "test return";
    }

    public static void main(String[] args) {
        execute();
        execute2();
        System.out.println("getValue() : " + getValue());
        System.out.println("getValue2() : " + getValue2());
        System.out.println("getValue3() : " + getValue3());
        System.out.println("getValue4() : " + getValue4());
    }
}

package com.xujun.base.keywords.kswitch;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午4:43:25 
  */

public class SwitchTest {

    public static void executeInt(int i) {
        switch (i) {
            case 1:
                System.out.println(i);
                break;
            default:
                System.out.println("default");;
        }
    }

    public static void executeString(String s) {
        switch (s) {
            case "a":
                System.out.println(s);
                break;
            default:
                System.out.println("default");;
        }
    }

    public static void main(String[] args) {
        executeInt(1); // 1
        executeInt(0); // default
        executeString("a"); // a
        executeString("b"); // default
    }
}

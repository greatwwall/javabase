package com.xujun.base.keywords.kstatic;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 上午10:36:17 
  */

public class OrderTest {

    public static void main(String[] args) {
        Son son = new Son();
        son.test();
        // person静态块
        // parent静态成员变量
        // parent静态块
        // son静态块,静态块和静态成员变量没有先后顺序
        // son静态成员变量
        // parent成员变量,非静态成员变量和构造器有先后顺序
        // parent构造器
        // son成员变量
        // son构造器
    }
}

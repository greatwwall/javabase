package com.xujun.base.pattern.builder;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午4:53:11 
  */

public class BuilderTest {

    public static void main(String[] args) {
        LenovoComputer computer = (LenovoComputer) Director.construct(new LenovoBuilder());
        System.out.println(computer.toString());
    }
}

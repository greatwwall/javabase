package com.xujun.base.pattern.builder;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午4:06:06 
  */

public interface Builder {

    void buildCpu();

    void buildRam();

    void buildScreen();

    void buildKeyboard();

    Computer build();
    
    default void print() {
        System.out.println(this.getClass().getName());
    }
}

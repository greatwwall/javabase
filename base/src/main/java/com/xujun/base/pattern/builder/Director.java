package com.xujun.base.pattern.builder;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午4:35:14 
  */

public class Director {

    public static Computer construct(Builder build) {
        build.buildCpu();
        build.buildRam();
        build.buildScreen();
        build.buildKeyboard();
        return build.build();
    }
}

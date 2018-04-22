package com.xujun.base.proxy.jdkdynamic;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 上午11:24:27 
  */

public class SpeakImpl implements Speakable {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    @Override
    public void sayBye(String name) {
        System.out.println("ByeBye, " + name);
    }

}

package com.xujun.base.proxy.jdkdynamic;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 上午11:32:26 
  */

public class JdkDynamicTest {

    public static void main(String[] args) {

        SpeakImpl target = new SpeakImpl();
        SpeakJdkProxy proxy = new SpeakJdkProxy();
        Speakable speak = (Speakable) proxy.bind(target);
        speak.sayHello("zhangsan");
        speak.sayBye("lisi");
    }
}

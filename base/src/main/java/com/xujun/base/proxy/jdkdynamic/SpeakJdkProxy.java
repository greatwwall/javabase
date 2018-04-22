package com.xujun.base.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 上午11:25:40 
  */

public class SpeakJdkProxy implements InvocationHandler {

    private Object target;


    /**
      * @todo 绑定真实对象并返回一个代理对象
      * @param target 真实对象
      * @return
      * @return Object 代理对象
      */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理");
        Object result = null;
        System.out.println("执行反射之前");
        result = method.invoke(target, args);
        System.out.println("执行反射之后");
        return result;
    }

}

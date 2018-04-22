package com.xujun.base.proxy.cglibdynamic;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 上午11:56:37 
  */

public class MyCglibProxy implements MethodInterceptor {

    public Object bind(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3)
            throws Throwable {
        System.out.println("执行Cglibproxy");
        System.out.println("before reflect");
        Object result = arg3.invokeSuper(arg0, arg2);// invokeSuper的第一个参数不同
        // result = arg3.invoke(this.target, arg2);
        System.out.println("after reflect");
        return result;
    }

}

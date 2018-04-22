package com.xujun.base.proxy.cglibdynamic;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 下午12:05:45 
  */

public class MyCglibTest {

    public static void main(String[] args) {
        CglibBean bean = new CglibBean();
        MyCglibProxy proxy = new MyCglibProxy();
        Object obj = proxy.bind(bean);
        ((CglibBean) obj).run("zhangsan");
    }
}

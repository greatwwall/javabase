package com.xujun.base.keywords.kthis;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午3:31:44 
  */

public class ThisConstructor {

    private int a;

    /**
     * 构造器里this调用另外一个构造器
     */
    public ThisConstructor() {
        this(1);
    }

    /**
     * @param i
     */
    public ThisConstructor(int i) {
        this.a = i;
    }

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * 方法里加this是因为两个变量都叫a,使用this表示把传入的a赋值给当前对象的a
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }
}

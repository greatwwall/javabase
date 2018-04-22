package com.xujun.base.thread;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月14日 下午9:26:16 
  */

public class ThreadLocalTest {

    static class Resource {
        // 看a的两个值能否一致
        public final static ThreadLocal<String> src1 = new ThreadLocal<String>();
        public final static ThreadLocal<String> src2 = new ThreadLocal<String>();
    }

    static class A {
        public void setOne(String value) {
            Resource.src1.set(value);
        }

        public void setTwo(String value) {
            Resource.src2.set(value);
        }
    }

    static class B {
        public void display() {
            System.out.println(Resource.src1.get() + " : " + Resource.src2.get());
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        for (int i = 0; i < 15; i++) {
            final String resource1 = "线程-" + i;
            final String resource2 = " value (" + i + ")";
            new Thread() {
                public void run() {
                    try {
                        a.setOne(resource1);
                        a.setTwo(resource2);
                        b.display();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        Resource.src1.remove();
                        Resource.src2.remove();
                    }
                }
            }.start();
        }
    }
}

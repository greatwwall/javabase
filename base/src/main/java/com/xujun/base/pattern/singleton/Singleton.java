package com.xujun.base.pattern.singleton;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:39:29 
  */

public class Singleton {

    private static Object lock = new Object();
    private static Singleton instance = new Singleton();
    private static Singleton instance2 = null;
    private static volatile Singleton instance3 = null;

    private Singleton() {}

    // 饿汉模式
    public static Singleton getInstance1() {
        return instance;
    }

    // 懒汉模式
    public static Singleton getInstance2() {
        if (null == instance2)
            instance2 = new Singleton();
        return instance2;
    }

    // 双重检查锁定
    public static Singleton getInstance3() {
        if (null == instance3)
            synchronized (lock) {
                if (null == instance3)
                    instance3 = new Singleton();
            }
        return instance3;
    }

    // 静态内部类
    public static Singleton getInstance4() {
        return SingletonHelper.instance4;
    }

    private static class SingletonHelper {
        public static Singleton instance4 = new Singleton();
    }

    // 枚举模式
    public static Singleton getInstance5() {
        return EnumSingleton.ENUMINSTANCE.getInstance();
    }

    private static enum EnumSingleton {
        ENUMINSTANCE;
        private Singleton sigle;

        private EnumSingleton() {
            sigle = new Singleton();
        }

        public Singleton getInstance() {
            return sigle;
        }
    }

    public static void main(String[] args) {
        Singleton single1 = Singleton.getInstance1();
        System.out.println(single1);
        Singleton single2 = Singleton.getInstance2();
        System.out.println(single2);
        Singleton single3 = Singleton.getInstance3();
        System.out.println(single3);
        Singleton single4 = Singleton.getInstance4();
        System.out.println(single4);
        Singleton single5 = Singleton.getInstance5();
        System.out.println(single5);

    }
}

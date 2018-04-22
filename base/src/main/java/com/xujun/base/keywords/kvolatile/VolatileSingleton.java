package com.xujun.base.keywords.kvolatile;

/**
 * @todo volatile 双重检查锁定单例模式
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 上午9:35:12
 */

public class VolatileSingleton {

    // private volatile static VolatileSingleton instance = null;
    private static VolatileSingleton instance = null;

    private VolatileSingleton() {}

    public static VolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                if (instance == null) {
                    // 初始化对象和把对象写入到变量中这两步操作是无序的,
                    // 因此一个线程走到这一步时可能看到一个非空引用,但却没有初始化的对象
                    // instance加上volatile可以保证双重检查锁定的线程安全,volatile可以保证多线程下共享变量的可见性
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }
}

package com.xujun.base.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午3:06:41
 */

public class LockSupportTest2 {

    /**
     * 不会打印c,会一直阻塞,因为LockSupport是不可重入的,第二次调用park方法时,线程无法获取许可出现死锁
     */
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);
        System.out.println("a.");
        LockSupport.park();
        System.out.println("b.");
        LockSupport.park();
        System.out.println("c.");
    }
}

package com.xujun.base.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午3:06:41
 */

public class LockSupportTest1 {

    /**
     * 不会打印,会一直阻塞,因为许可默认是被占用的,去掉注释可打印
     */
    public static void main(String[] args) {
        // Thread thread = Thread.currentThread();
        // LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("block.");
    }
}

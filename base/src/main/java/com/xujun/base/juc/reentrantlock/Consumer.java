package com.xujun.base.juc.reentrantlock;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午2:01:03
 */

public class Consumer {

    private Depot depot;

    /**
     * @param depot
     */
    public Consumer(Depot depot) {
        super();
        this.depot = depot;
    }

    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot.cousume(val);
            }
        }.start();
    }
}

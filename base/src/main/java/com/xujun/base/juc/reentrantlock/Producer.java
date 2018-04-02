package com.xujun.base.juc.reentrantlock;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午1:57:07
 */

public class Producer {

    private Depot depot;

    /**
     * @param depot
     */
    public Producer(Depot depot) {
        super();
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot.produce(val);
            }
        }.start();
    }

}

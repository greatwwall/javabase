package com.xujun.base.juc.reentrantlock;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午2:02:59
 */

public class ReentrantLockTest {

    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Consumer consumer = new Consumer(depot);

        producer.produce(60);
        producer.produce(120);
        consumer.consume(90);
        consumer.consume(150);
        producer.produce(110);
    }
}

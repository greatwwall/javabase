package com.xujun.base.juc.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @todo 当线程池策略设置为"丢弃"时,超出线程池容量的线程会被丢弃
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午5:56:23
 */

public class ThreadPoolDiscardPolicyTest1 {

    private static final int threadSize = 1;
    private static final int capacity = 1;

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(threadSize, threadSize, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(capacity));

        // 设置线程池的拒绝策略为"丢弃"
        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        // 设置线程池策略为"DiscardOldestPolicy"时,当有任务添加到线程池被拒绝时,
        // 线程池会丢弃阻塞队列末尾的任务,然后将被拒绝的任务添加到末尾
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        // 新建10个线程添加到线程池中
        for (int i = 0; i < 10; i++) {
            Runnable run = new MyThread("thread " + i);
            pool.execute(run);
        }
        pool.shutdown();
    }

    static class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void run() {
            try {
                System.out.println(this.name + " is running.");
                Thread.sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

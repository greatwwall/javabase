package com.xujun.base.juc.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午5:56:23
 */

public class ThreadPoolDiscardPolicyTest2 {

    private static final int threadSize = 1;
    private static final int capacity = 1;

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(threadSize, threadSize, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(capacity));

        // 设置线程池的拒绝策略为"AbortPolicy",会抛出异常
        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // 设置线程池的拒绝策略为"CallerRunsPolicy",会把被拒绝的线程添加到线程池中运行
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 新建10个线程添加到线程池中
        try {
            for (int i = 0; i < 10; i++) {
                Runnable run = new MyThread("task-" + i);
                pool.execute(run);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
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

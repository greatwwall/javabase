package com.xujun.base.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @todo 前两个线程取到信号量许可以后,第三个线程只剩一个许可,此时不足7个信号量许可, 
 *          所以第三个线程必须等待前两个线程释放完信号量许可以后才可以获取许可
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午5:09:45
 */

public class SemaphoreTest1 {

    private static int semSize = 10;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(semSize);
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        // 在线程池中执行任务
        threadPool.execute(new MyThread(sem, 5));
        threadPool.execute(new MyThread(sem, 4));
        threadPool.execute(new MyThread(sem, 7));
        // 关闭线程池
        threadPool.shutdown();
    }

    static class MyThread extends Thread {
        private volatile Semaphore sem; // 申请的信号量
        private int count; // 信号量大小

        /**
         * @param sem
         * @param count
         */
        public MyThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }

        public void run() {
            try {
                // 从信号量中获取count个许可
                sem.acquire(count);
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " acquire count: " + count);
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                // 释放所有信号量许可,将其返回给信号量
                sem.release(count);
                System.out.println(Thread.currentThread().getName() + " release count: " + count);
            }
        }
    }
}

package com.xujun.base.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午5:37:17
 */

public class SemaphoreTest2 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);

        new ThreadA(sem1, sem2).start();
        new ThreadB(sem1, sem2).start();
        // 此时陷入死锁,ThreadA获得sem1的许可,请求sem2的许可
        // 而ThreadB已获得sem2的许可,请求sem1的许可,相互请求造成死锁

        TimeUnit.SECONDS.sleep(5);
        // 去掉后面两句的注释可回复死锁,而且此时线程为主线程,也就是说可以通过非owner线程来实现死锁恢复
        sem1.release();
        sem2.release();


    }

    static class ThreadA extends Thread {
        private Semaphore sem1, sem2;

        public ThreadA(Semaphore sem1, Semaphore sem2) {
            this.sem1 = sem1;
            this.sem2 = sem2;
        }

        public void run() {
            try {
                sem1.acquire();
                System.out.println(Thread.currentThread().getName() + " acquire sem1");
                TimeUnit.SECONDS.sleep(5); // 等待5秒,为了让ThreadB先获得sem2
                sem2.acquire();
                System.out.println(Thread.currentThread().getName() + " acquire sem2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        private Semaphore sem1, sem2;

        public ThreadB(Semaphore sem1, Semaphore sem2) {
            this.sem1 = sem1;
            this.sem2 = sem2;
        }

        public void run() {
            try {
                sem2.acquire();
                System.out.println(Thread.currentThread().getName() + " acquire sem2");
                TimeUnit.SECONDS.sleep(5); // 等待5秒,为了让ThreadA先获得sem1
                sem1.acquire();
                System.out.println(Thread.currentThread().getName() + " acquire sem1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

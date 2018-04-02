package com.xujun.base.juc.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午2:46:01
 */

public class ConditionTest {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ThreadA threada = new ThreadA("test");
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start.");
            threada.start();
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + " block.");
            condition.await(); // 会释放锁
            System.out.println(Thread.currentThread().getName() + " continue.");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " unlock.");
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " try get lock.");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " wakeup others.");
                condition.signal();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock.");
            }
        }
    }
}

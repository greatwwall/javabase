package com.xujun.base.juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午4:57:15
 */

public class CyclicBarrierTest {

    private static int cbSize = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb = new CyclicBarrier(cbSize, new Runnable() {

            public void run() {
                System.out.println("CyclicBarrier's patries is " + cb.getParties());
            }
        });

        for (int i = 0; i < 5; i++) {
            new InnerThread().start();

        }
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
                cb.await();
                // cb的数量为5时才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

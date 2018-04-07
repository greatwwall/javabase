package com.xujun.base.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @todo "主线程"等待"5个子线程"全部都完成"指定的工作(休眠1000ms)"之后，再继续运行。
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午4:43:44
 */

public class CountDownLatchTest {

    private static int latchSize = 5;
    private static CountDownLatch latch;

    public static void main(String[] args) {
        try {
            latch = new CountDownLatch(latchSize);
            System.out.println("main start.");
            // 创建5个子线程
            for (int i = 0; i < 5; i++) {
                new InnerThread().start();
            }
            latch.await();
            System.out.println("main await end.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000.");
                latch.countDown();
                System.out.println("latch count: " + latch.getCount());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

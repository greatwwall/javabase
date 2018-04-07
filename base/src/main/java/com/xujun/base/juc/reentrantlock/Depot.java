package com.xujun.base.juc.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @todo ReentrantLock是一个可重入互斥锁,独占锁
 *      可重入:可以被单个线程多次获取
 *      ReentrantLock通过一个FIFO的队列来管理线程
 *      
 *      ReentrantLock实现了Lock接口
 *      ReentrantLock和Sync是组合关系
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午1:34:03
 */

public class Depot {

    private int capacity; // 仓库的容量
    private int size; // 仓库的实际数量
    private Lock lock; // 独占锁
    private Condition fullCondition; // 生产条件
    private Condition emptyCondition; // 消费条件

    /**
     * @param capacity
     */
    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.fullCondition = lock.newCondition();
        this.emptyCondition = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        int left = val; // left:生产量
        try {
            while (left > 0) {
                // 库存已满等待消费者消费
                while (size >= capacity) {
                    fullCondition.await();
                }
                // 实际能生产的数量
                int realPro = (left + size) > capacity ? (capacity - size) : left;
                size += realPro;
                left -= realPro;
                System.out.printf("%s produce(%3d) --> left=%3d, realPro=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, realPro, size);
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void cousume(int val) {
        lock.lock();
        int left = val;

        try {
            while (left > 0) {
                // 库存为0,等待生产
                while (size <= 0) {
                    emptyCondition.await();
                }
                int result = (size < left) ? size : left;
                size -= result;
                left -= result;
                System.out.printf("%s consume(%3d) <-- left=%3d, result=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, result, size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Depot [capacity=" + capacity + ", size=" + size + "]";
    }

}

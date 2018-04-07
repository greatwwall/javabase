package com.xujun.base.juc.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午4:11:01
 */

public class User {

    private String name;
    private Count count;
    private ReadWriteLock lock;

    /**
     * @param name
     * @param count
     */
    public User(String name, Count count) {
        super();
        this.name = name;
        this.count = count;
        this.lock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread() {
            public void run() {
                lock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " getCash start.");
                    count.getCash();
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " getCash end.");
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    lock.readLock().unlock();
                }
            }
        }.start();
    }

    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                lock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " setCash start.");
                    count.setCash(cash);
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " setCash end.");
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }.start();
    }
}

package com.xujun.base.juc.readwrite;

/**
 * @todo 只要"写入锁"被某线程获取,则必须该写入线程执行完毕,才释放该锁.
 * @author xujun
 * @version 1.0
 * @date 2018年4月2日 下午4:05:11
 */

public class ReadWriteTest1 {

    public static void main(String[] args) {
        Count count = new Count("6216222233334444555", 10000);
        User user = new User("Tommy", count);

        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash((i + 1) * 1000);
        }
    }
}

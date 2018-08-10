package com.xujun.base.keywords.kfinal;

import java.util.Arrays;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月7日 下午4:17:13
 */

public class FinalClosure {

    // 定义一个方法生产指定长度的数组,但每个元素由 cmd生产
    public int[] process(IntArrayProductor cmd, int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = cmd.product();
        }
        return result;
    }

    public void threadTest() {
        final String str = "java";
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(str + " " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        // int seed = 5;
        final int seed = 5;
        class IntArrayProductorImpl implements IntArrayProductor {

            @Override
            public int product() {
                return (int) Math.round((Math.random() * seed));
            }
        }
        int[] result = new FinalClosure().process(new IntArrayProductorImpl(), 10);
        System.out.println(Arrays.toString(result));
    }
}

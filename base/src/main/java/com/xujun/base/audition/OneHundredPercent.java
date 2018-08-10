package com.xujun.base.audition;

/**
  * @todo 用1分,2分,5分凑成一元的种类
  * @author xujun
  * @version 1.0
  * @date 2018年4月25日 下午5:28:35 
  */

public class OneHundredPercent {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 50; j++) {
                for (int k = 0; k <= 100; k++) {
                    if ((5 * i + 2 * j + k) == 100) {
                        count++;
                    }
                }
            }
        }
        System.out.println("count : " + count);
    }

}

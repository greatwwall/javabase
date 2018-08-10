package com.xujun.base.audition;

/**
  * @todo 张三说李四在说谎，李四说王五在说谎，王五说张三和李四都在说谎。
  *     现在问：这三人中到底谁说的是真话，谁说的是假话？
  * @author xujun
  * @version 1.0
  * @date 2018年4月25日 下午5:34:39 
  */

public class WhoIsLiar {

    // a张三说李四在说谎 zhangsan == !lisi
    // b李四说王五在说谎 lisi == !wangwu
    // c王五说张三和李四都在说谎 wangwu = (!zhangsan)&&(!lisi)
    // bc代入a得出: zhangsan == wangwu
    // 并且 lisi == (zhangsan || lisi)
    public static void main(String[] args) {
        // 0 假 说谎
        // 1 真 没有说谎
        for (int zhangsan = 0; zhangsan <= 1; zhangsan++) {
            for (int lisi = 0; lisi <= 1; lisi++) {
                for (int wangwu = 0; wangwu <= 1; wangwu++) {
                    lisi = (zhangsan > 0 || lisi > 0) ? 0 : 1;
                    if ((zhangsan == 0 && wangwu == 0) && (lisi > 0)) {
                        System.out.println("zhangsan " + zhangsan);
                        System.out.println("lisi " + lisi);
                        System.out.println("wangwu " + wangwu);
                    }
                }
            }
        }
    }
}

package com.xujun.base.keywords.kfinal;

/**
 * @todo 反编译 javap -c FinalLocalVar > FinalLocalVar.txt 得到class的指令,会发现文件中没有编译变量num
 *       执行System.out.println(num)时直接执行的是System.out.println(5)
 * @author xujun
 * @version 1.0
 * @date 2018年4月7日 下午3:35:16
 */

public class FinalLocalVar {

    public static void main(String[] args) {
        final int num = 5;
        System.out.println(num);
    }
}

package com.xujun.base.keywords.kfinal;

/**
 * @todo 反编译 javap -c FinalClassVar > FinalClassVar.txt 得到class的指令,有两个putstatic
 *       可知,本质上final实例变量只能在静态初始化块中被赋初始值
 * @author xujun
 * @version 1.0
 * @date 2018年4月7日 下午2:57:37
 */

public class FinalClassVar {

    private final static int num = "修饰类静态变量".length();
    private final static int num2;

    static {
        num2 = "类静态变量在静态块中赋值".length();
    }

    public static void main(String[] args) {
        System.out.println("FinalClassVar.num :" + FinalClassVar.num);
        System.out.println("FinalClassVar.num2:" + FinalClassVar.num2);
    }
}

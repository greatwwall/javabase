package com.xujun.base.thread;

import java.util.ArrayList;
import java.util.List;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月13日 下午5:32:50 
  */

public class TestMat {

    static class Mat {
        private String name;

        /**
         * @param name
         */
        public Mat(String name) {
            super();
            this.name = name;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建死循环
        List<Mat> list = new ArrayList<Mat>();
        int num = 1;
        while (num < 1000000) {
            list.add(new Mat("num " + num));
        }
    }
}

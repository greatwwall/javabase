package com.xujun.base.collection;

import java.util.ArrayList;
import java.util.List;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月13日 上午9:01:57 
  */

public class ListRemove {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("root");
        list.add("zhangsan");
        list.add("lisi");
        System.out.println(list);
        list.remove("root");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}

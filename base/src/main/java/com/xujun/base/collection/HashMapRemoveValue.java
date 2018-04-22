package com.xujun.base.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
  * @todo 删除HashMap的某个value
  * @author xujun
  * @version 1.0
  * @date 2018年4月14日 下午9:49:44 
  */

public class HashMapRemoveValue {

    // Iterator的遍历删除
    public static Map<String, String> removeValue(Map<String, String> map, String value) {
        Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                iterator.remove();
            }
        }
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("admin", "adminValue");
        map.put("root", "rootValue");
        map.put("key", "value");
        map.put("root2", "rootValue");
        System.out.println("before remove ");
        System.out.println(map);
        removeValue(map, "rootValue");
        System.out.println("after remove");
        System.out.println(map);
    }
}

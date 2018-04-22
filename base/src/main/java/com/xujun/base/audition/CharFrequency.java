package com.xujun.base.audition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
  * @todo 单词频率 
  * @author xujun
  * @version 1.0
  * @date 2018年4月16日 下午9:53:52 
  */

public class CharFrequency {


    public static Map<String, Integer> test(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
        Integer val = 0;
        for (int i = 0; i < array.length; i++) {
            val = map.get(array[i]);
            val = val == null ? 0 : val;
            if (val != null) {
                map.put(array[i], val + 1);
            }
        }
        return map;
    }

    public static List<Entry<String, Integer>> sort(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list =
                new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return list;
    }

    private static void print(Iterator<Entry<String, Integer>> iterator) {
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> en = iterator.next();
            System.out.println(en.getKey() + " : " + en.getValue());
        }
    }

    public static void main(String[] args) {
        String s = "ab cd de ef ab cd ef ag cd se ef agc sde sde kd adk ad ef as kl";
        Map<String, Integer> map = test(s);
        print(map.entrySet().iterator());
        System.out.println("-------------------------");
        List<Entry<String, Integer>> map2 = sort(map);
        print(map2.iterator());
    }


}

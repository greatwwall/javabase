package com.xujun.base.audition;

import java.util.HashMap;
import java.util.Map;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月28日 下午5:02:04 
  */

public class FirstCharAppearsOnce {


    public static int get(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int temp = map.get(str.charAt(i)) != null ? map.get(str.charAt(i)) : 0;
            map.put(str.charAt(i), ++temp);
        }
        System.out.println(map.toString());
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s.equals(c));
        String str = "aabcdabceghiaed";
        int k = get(str);
        System.out.println(str.charAt(k));
    }
}

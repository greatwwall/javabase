package com.xujun.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月11日 下午6:07:23 
  */

public class Beijing {

    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        // 正则取出 北京市
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.groupCount());
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        }
    }
}

package com.xujun.base.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @todo 写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数
 * @author xujun
 * @version 1.0
 * @date 2018年4月5日 下午5:58:03
 */

public class CountOfChar {

    private CountOfChar() {}

/*    public static int countWordInFile(String filename, String word)
            throws FileNotFoundException, IOException {
        int count = 0;
        try (FileReader fr = new FileReader(filename)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = null;
                int index = -1;
                while ((line = br.readLine()) != null) {
                    while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
                        count++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        }
        return count;
    }*/
}

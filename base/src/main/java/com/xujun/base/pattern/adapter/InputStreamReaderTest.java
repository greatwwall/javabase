package com.xujun.base.pattern.adapter;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午5:57:26 
  */

public class InputStreamReaderTest {

    public static void main(String[] args) {
        InputStream input = new InputStreamImpl();
        Reader read = new InputStreamReader(input);
        read.read();
    }
}

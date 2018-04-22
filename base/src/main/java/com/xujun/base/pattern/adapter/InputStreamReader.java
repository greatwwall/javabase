package com.xujun.base.pattern.adapter;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午5:50:25 
  */

public class InputStreamReader extends Reader implements InputStream {

    private InputStream inputStream;

    // 持有要适配的接口
    public InputStreamReader(InputStream inputStream) {
        super();
        this.inputStream = inputStream;
    }

    @Override
    public void input() {}

    @Override
    public void read() {
        inputStream.input();
    }
}

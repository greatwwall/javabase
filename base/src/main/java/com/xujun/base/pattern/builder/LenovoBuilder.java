package com.xujun.base.pattern.builder;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午4:41:46 
  */

public class LenovoBuilder implements Builder {

    private Computer lenovo;

    public LenovoBuilder() {
        this.lenovo = new LenovoComputer();
    }

    @Override
    public void buildCpu() {
        lenovo.setCpu("LenovoCpu");
    }

    @Override
    public void buildRam() {
        lenovo.setRam("LenovoRam");
    }

    @Override
    public void buildScreen() {
        lenovo.setScreen("LenovoScrren");
    }

    @Override
    public void buildKeyboard() {
        lenovo.setKeyboard("Lenovokeyboard");
    }

    @Override
    public Computer build() {
        lenovo.label();
        this.print();
        return lenovo;
    }

}

package com.xujun.base.pattern.builder;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月9日 下午4:12:36 
  */

public abstract class Computer {

    private String cpu;
    private String ram;
    private String screen;
    private String keyboard;

    public Computer() {
        super();
    }

    public Computer(String cpu, String ram, String screen, String keyboard) {
        super();
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    /**
     * @return the cpu
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * @return the ram
     */
    public String getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * @return the screen
     */
    public String getScreen() {
        return screen;
    }

    /**
     * @param screen the screen to set
     */
    public void setScreen(String screen) {
        this.screen = screen;
    }

    /**
     * @return the keyboard
     */
    public String getKeyboard() {
        return keyboard;
    }

    /**
     * @param keyboard the keyboard to set
     */
    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + ", screen=" + screen + ", keyboard="
                + keyboard + "]";
    }
    
    public abstract void label();
}

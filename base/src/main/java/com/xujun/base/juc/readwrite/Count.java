package com.xujun.base.juc.readwrite;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月2日 下午4:06:32 
  */

public class Count {

    private String id;
    private int cash;
    /**
     * @param id
     * @param cash
     */
    public Count(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the cash
     */
    public int getCash() {
        System.out.println(Thread.currentThread().getName() + " get cash " + cash);
        return cash;
    }
    /**
     * @param cash the cash to set
     */
    public void setCash(int cash) {
        System.out.println(Thread.currentThread().getName() + " set cash " + cash);
        this.cash = cash;
    }
    
    
    
}

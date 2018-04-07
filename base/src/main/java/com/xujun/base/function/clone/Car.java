package com.xujun.base.function.clone;

import java.io.Serializable;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月5日 下午3:45:01
 */

public class Car implements Serializable {

    private static final long serialVersionUID = 7402552190980264801L;
    private String name;

    /**
     * @param name
     */
    public Car(String name) {
        super();
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Car [name=" + name + "]";
    }


}

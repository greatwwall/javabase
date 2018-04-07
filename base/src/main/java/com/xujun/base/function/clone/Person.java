package com.xujun.base.function.clone;

import java.io.Serializable;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月5日 下午3:47:17
 */

public class Person implements Serializable{

    private static final long serialVersionUID = -4302027210134310554L;
    private String name;
    private Car car;

    /**
     * @param name
     * @param car
     */
    public Person(String name, Car car) {
        super();
        this.name = name;
        this.car = car;
    }

    /**
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
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
        return "Person [name=" + name + ", car=" + car + "]";
    }


}

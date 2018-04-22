package com.xujun.base.classp;

import java.io.Serializable;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午8:44:44 
  */

public class Employee implements Cloneable, Serializable {

    private static final long serialVersionUID = 6140793629326230909L;

    public String name;
    private int age;


    public Employee() {}

    public Employee(String name) {
        super();
        this.name = name;
    }

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee employee = (Employee) obj;
        if (name == null) {
            if (employee.name != null)
                return false;
        } else if (!name.equals(employee.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString() {
        return "[Employee name : " + this.getName() + ", hashcode :" + this.hashCode() + "]";
    }
}

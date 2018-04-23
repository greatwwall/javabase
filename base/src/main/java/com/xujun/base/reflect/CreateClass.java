package com.xujun.base.reflect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.net.URL;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午8:30:29 
  */

public class CreateClass {

    public static void main(String[] args) throws Exception {
        // 1.直接new
        Employee emp = new Employee("Arb");
        System.out.println(emp.toString());

        // 2.通过class.newInstance
        emp = Employee.class.newInstance();
        emp.setName("Arc");
        System.out.println(emp.toString());

        // 3.通过反射构造器得到
        Constructor<Employee> con = Employee.class.getConstructor();
        emp = con.newInstance();
        emp.setName("Ard");
        System.out.println(emp.toString());

        // 4.通过clone
        Employee emp2 = (Employee) emp.clone();
        emp2.setName("Clone");
        System.out.println(emp2.toString());

        // 5.通过反序列化
        emp2.setName("Serializable");
        System.out.println(emp2.toString());
        URL url = CreateClass.class.getResource("");
        String path = url.toString().substring(5) + "CreatClass.txt";
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
        os.writeObject(emp2);
        os.flush();
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
        Employee emp5 = (Employee) is.readObject();
        is.close();
        System.out.println(emp5.toString());
    }

}

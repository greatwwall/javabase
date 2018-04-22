package com.xujun.base.classp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午9:18:29 
  */

public class ReflectTest {

    public static void test() throws ClassNotFoundException {
        // 获取类3种方法
        Class<?> clazz = Class.forName("com.xujun.base.classp.Employee");
        System.out.println("clazz : " + clazz);
        Class<?> clazz2 = Employee.class;
        System.out.println("clazz2 : " + clazz2);
        Employee emp = new Employee();
        Class<?> clazz3 = emp.getClass();
        System.out.println("clazz3 : " + clazz3);
        System.out.println("---------------------------------------------");

        // 获取方法
        Method[] methods = clazz3.getMethods();
        for (Method method : methods) {
            System.out.println("method " + method);
        }
        System.out.println("---------------------------------------------");

        // 获取实现的接口
        Class<?>[] interfaces = clazz3.getInterfaces();
        for (Class<?> class1 : interfaces) {
            System.out.println("interface :" + class1);
        }
        System.out.println("---------------------------------------------");

        // 获取父类
        Class<?> superClass = clazz3.getSuperclass();
        System.out.println("superClass :" + superClass);
        System.out.println("---------------------------------------------");

        // 获取构造函数
        Constructor<?>[] constructors = clazz3.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor :" + constructor);
        }
        System.out.println("---------------------------------------------");

        // 获取所有属性,包括private,public,protected
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field : " + field);
        }
        System.out.println("---------------------------------------------");

        // 获取所有public属性,会包括父类的
        Field[] fields2 = clazz.getFields();
        for (Field field : fields2) {
            System.out.println("field2 : " + field);
        }
        System.out.println("---------------------------------------------");
    }

    public static void testReflect() throws Exception {
        Class<?> clazz = Class.forName("com.xujun.base.classp.Employee");
        Object emp = clazz.newInstance();
        Field nameField = clazz.getDeclaredField("name");
        // 打破封装 实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
        // 由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
        nameField.setAccessible(true);
        // 给name属性赋值
        nameField.set(emp, "xiaowang");
        System.out.println(nameField.get(emp));

        Method nameMethod = clazz.getDeclaredMethod("setName", String.class);
        nameMethod.setAccessible(true);
        nameMethod.invoke(emp, "xiaoli");
        System.out.println("name : " + ((Employee) emp).getName());
        // 向下转型
        Employee e = (Employee) emp;
        e.setAge(27);
        System.out.println(e.toString());

    }

    public static void main(String[] args) throws Exception {
        test();
        testReflect();
    }
}

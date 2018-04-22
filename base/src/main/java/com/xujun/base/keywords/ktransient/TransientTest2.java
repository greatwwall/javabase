package com.xujun.base.keywords.ktransient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

/**
 * @todo 实现Serilizable接口，将不需要序列化的属性前添加关键字transient， 
 *      序列化对象的时候，这个属性就不会序列化到指定的目的地中。 反序列化后password为null
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 下午2:31:52
 */

public class TransientTest2 {

    /**
     * 1.一旦变量被transient修饰,变量将不再是对象持久化的一部分,该变量内容在序列化后无法获得,即为null 
     * 2.transient只能修饰变量,不能修饰类和方法
     * 3.一个静态变量不管是否被transient修饰,均不能被序列化
     * 
     * @todo
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @return void
     */
    @SuppressWarnings("resource")
    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        User2 user = new User2("xujun", "123456");
        System.out.println("before Serializable");
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());

        URL path = TransientTest2.class.getResource("");
        String abpath = path.toString() + "TransientTest.txt";
        abpath = abpath.substring(5);
        System.out.println(abpath);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abpath));
        // 讲user对象写到文档中
        oos.writeObject(user);
        oos.flush();
        oos.flush();
        // 反序列化之前重命名
        user.setUsername("xujun2");;
        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(abpath));
        User2 user2 = (User2) ois.readObject();
        ois.close();
        System.out.println("after Serializable");
        // xujun2, 说明反序列化后类中的静态变量的username中的值为当前JVM中的对应的static username的值xujun2,
        // 不是序列化时的xujun
        System.out.println("username :" + user2.getUsername());
        System.out.println("password :" + user2.getPassword()); // null
    }

}

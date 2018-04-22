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

public class TransientTest {

    @SuppressWarnings("resource")
    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        User user = new User("xujun", "123456");
        System.out.println("before Serializable");
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());

        URL path = TransientTest.class.getResource("");
        String abpath = path.toString() + "TransientTest.txt";
        abpath = abpath.substring(5);
        System.out.println(abpath);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abpath));
        // 讲user对象写到文档中
        oos.writeObject(user);
        oos.flush();
        oos.flush();

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(abpath));
        User user2 = (User) ois.readObject();
        ois.close();
        System.out.println("after Serializable");
        System.out.println("username :" + user2.getUsername());
        System.out.println("password :" + user2.getPassword()); // null
    }

}

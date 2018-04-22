package com.xujun.base.keywords.ktransient;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;

/**
 * @todo 若实现的是
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 下午2:31:52
 */

public class TransientTest3 implements Externalizable {

    private transient String content = "我将被序列化,我被transient修饰";
    private String content2 = "我将被序列化,我不被transient修饰";


    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        TransientTest3 tt = new TransientTest3();
        URL path = TransientTest3.class.getResource("");
        String abpath = path.toString() + "TransientTest3.txt";
        abpath = abpath.substring(5);
        System.out.println(abpath);
        ObjectOutput oop = new ObjectOutputStream(new FileOutputStream(abpath));
        oop.writeObject(tt);
        oop.flush();
        oop.close();
        // 反序列化
        ObjectInput oip = new ObjectInputStream(new FileInputStream(abpath));
        TransientTest3 tt2 = (TransientTest3) oip.readObject();
        System.out.println(tt2.content2);
        System.out.println(tt2.content);
        oip.close();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content2);
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content2 = (String) in.readObject();
        content = (String) in.readObject();
    }

}

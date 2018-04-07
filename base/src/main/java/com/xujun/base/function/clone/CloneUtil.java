package com.xujun.base.function.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @todo 通过反序列化实现深度克隆
 * @author xujun
 * @version 1.0
 * @date 2018年4月5日 下午3:35:05
 */

public class CloneUtil {

    private CloneUtil() {

    }

    @SuppressWarnings("unchecked")
    public static <T> T clone(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (T) ois.readObject();
    }
}

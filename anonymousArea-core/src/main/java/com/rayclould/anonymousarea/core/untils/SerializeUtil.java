package com.rayclould.anonymousarea.core.untils;

import java.io.*;

/**
 * 序列化通用方法
 *
 * @Author: nanCheng
 * @Date: 2018/08/06
 */

public class SerializeUtil {

    /**
     * 序列化
     */
    public static String serialize(Object object) {
        if (object == null) {
            return null;
        }
        ObjectOutputStream oos;
        ByteArrayOutputStream baos;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return new String(bytes, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     */
    public static Object unserialize(String s) throws UnsupportedEncodingException {
        byte[] bytes = s.getBytes("utf-8");
        ByteArrayInputStream bais;
        try {
            //反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
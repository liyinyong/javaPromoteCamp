package com.example.firstweekhomework.firstweek;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

@Slf4j
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = null;
        try {
            File file = new File("Hello.xlass");
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            data = bos.toByteArray();
            bos.close();
        } catch (Exception e) {
            log.error("", e);
        }
        if (data == null) {
            return null;
        }
        byte[] newDatas = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            newDatas[i] = (byte) (255 - data[i]);
        }
        return defineClass(name, newDatas, 0, newDatas.length);
    }
}

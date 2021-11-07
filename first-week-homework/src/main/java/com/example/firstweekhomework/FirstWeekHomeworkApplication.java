package com.example.firstweekhomework;

import com.example.firstweekhomework.firstweek.MyClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
public class FirstWeekHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstWeekHomeworkApplication.class, args);
        firstWeekHomeWork();
    }

    private static void firstWeekHomeWork() {
        try {
            Class helloClass = new MyClassLoader().findClass("Hello");
            Object hello = helloClass.newInstance();
            Method method = helloClass.getMethod("hello", new Class[]{});
            method.invoke(hello);
        } catch (Exception e) {
        }
    }
}

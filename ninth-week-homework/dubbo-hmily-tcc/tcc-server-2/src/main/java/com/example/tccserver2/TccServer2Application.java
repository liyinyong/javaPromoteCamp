package com.example.tccserver2;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo(scanBasePackages ="com.example")
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan(basePackages = "com.example.tccserver2.mapper")
public class TccServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(TccServer2Application.class, args);
    }

}

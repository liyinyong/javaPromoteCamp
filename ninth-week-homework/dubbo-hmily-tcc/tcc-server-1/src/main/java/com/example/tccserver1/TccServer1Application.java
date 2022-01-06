package com.example.tccserver1;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan(basePackages = "com.example.tccserver1.mapper")
@EnableDubbo(scanBasePackages ="com.example")
public class TccServer1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TccServer1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}

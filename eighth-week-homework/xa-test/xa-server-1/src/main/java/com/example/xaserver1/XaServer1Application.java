package com.example.xaserver1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@MapperScan("com.example.xaserver1.mapper")
public class XaServer1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(XaServer1Application.class, args);
    }


    @Resource
    private OrderInfoService orderInfoService;
    @Override
    public void run(String... args) throws Exception {
        orderInfoService.addOrder();
    }
}

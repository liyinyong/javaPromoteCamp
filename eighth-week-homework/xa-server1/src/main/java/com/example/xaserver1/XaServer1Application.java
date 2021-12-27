package com.example.xaserver1;

import com.example.xaserver2.service.OrderApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class XaServer1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(XaServer1Application.class, args);
    }

    @Resource
    private OrderApi orderApi;

    @Override
    public void run(String... args) throws Exception {
        orderApi.createOrder(100, 1);
    }
}

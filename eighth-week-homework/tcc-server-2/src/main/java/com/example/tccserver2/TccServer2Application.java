package com.example.tccserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableFeignClients("com.example")
@EnableEurekaClient
@ComponentScan("com.example")
public class TccServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(TccServer2Application.class, args);
    }

}

package com.example.tccserver1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableFeignClients("com.example")
@EnableEurekaClient
@ComponentScan("com.example")
@MapperScan("com.example.tccserver1.mapper")
public class TccServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(TccServer1Application.class, args);
    }

}

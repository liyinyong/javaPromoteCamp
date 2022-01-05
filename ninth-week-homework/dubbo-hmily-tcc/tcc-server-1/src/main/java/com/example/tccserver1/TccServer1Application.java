package com.example.tccserver1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TccServer1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TccServer1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}

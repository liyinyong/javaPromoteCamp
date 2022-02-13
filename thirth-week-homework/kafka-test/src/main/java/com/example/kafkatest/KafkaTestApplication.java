package com.example.kafkatest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class KafkaTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTestApplication.class, args);
    }



    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send("test",  "key", "test message send~");
    }
}

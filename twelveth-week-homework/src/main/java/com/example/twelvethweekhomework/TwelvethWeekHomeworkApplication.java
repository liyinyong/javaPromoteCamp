package com.example.twelvethweekhomework;

import com.example.twelvethweekhomework.mq.ActiveProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication(scanBasePackages = "com.example.twelvethweekhomework")
public class TwelvethWeekHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TwelvethWeekHomeworkApplication.class, args);
    }


    @Resource
    private ActiveProducer activeProducer;
    @Override
    public void run(String... args) throws Exception {
        activeProducer.sendMessage("test111");
        activeProducer.sendTopic("test222");
    }
}

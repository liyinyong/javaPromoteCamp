package com.example.mymqtest;

import com.example.mymqapi.api.MyMqApi;
import com.example.mymqapi.model.KmqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class MyMqTestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyMqTestApplication.class, args);
    }

    @Resource
    private MyMqApi myMqApi;
    @Override
    public void run(String... args) throws Exception {
        KmqMessage kmqMessage = new KmqMessage<String>();
        kmqMessage.setBody("test");
        myMqApi.sendMessage("test", kmqMessage);

        KmqMessage message = myMqApi.getMessage("test");
        log.info("message{}", message);
    }
}

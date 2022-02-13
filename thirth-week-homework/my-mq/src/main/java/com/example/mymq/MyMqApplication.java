package com.example.mymq;

import com.example.mymq.core.KmqBroker;
import com.example.mymq.core.KmqConsumer;
import com.example.mymqapi.model.KmqMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MyMqApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyMqApplication.class, args);
    }

    @Resource
    private KmqBroker kmqBroker;

    @Override
    public void run(String... args) throws Exception {
        kmqBroker.createTopic("test");
//        KmqMessage kmqMessage = new KmqMessage<String>();
//        kmqMessage.setBody("test my message");
//        kmqBroker.findKmq("test").send(kmqMessage);
//
//        KmqConsumer kmqConsumer = new KmqConsumer(kmqBroker);
    }


}

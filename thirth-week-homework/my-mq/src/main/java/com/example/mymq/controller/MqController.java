package com.example.mymq.controller;

import com.example.mymq.core.KmqBroker;
import com.example.mymq.core.KmqConsumer;
import com.example.mymq.core.KmqProducer;
import com.example.mymqapi.model.KmqMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mq")
public class MqController {
    @Resource
    private KmqProducer kmqProducer;
    @Resource
    private KmqBroker kmqBroker;

    @PostMapping("/send")
    public Boolean sendMessage(@RequestParam("topic") String topic,
                               @RequestParam("message") KmqMessage message) {
        return kmqProducer.send(topic, message);
    }

    @PostMapping("/get")
    public KmqMessage getMessage(@RequestParam("topic") String topic) {
        return kmqBroker.findKmq(topic).poll();
    }
}


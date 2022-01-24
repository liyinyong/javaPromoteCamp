package com.example.twelvethweekhomework.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

@Component
@Slf4j
public class ActiveConsume {

    @JmsListener(destination = "test.queue")
    public void produceMessage(String message) {
        log.info("消费消息:{}", message);
    }


    @JmsListener(destination = "test.topic")
    public void receiveTopic1(String text) {
        log.info("receiveTopic1接收到Topic消息:{}", text);
    }

    @JmsListener(destination = "test.topic")
    public void receiveTopic2(String text) {
        log.info("receiveTopic2接收到Topic消息:{} ", text);
    }
}

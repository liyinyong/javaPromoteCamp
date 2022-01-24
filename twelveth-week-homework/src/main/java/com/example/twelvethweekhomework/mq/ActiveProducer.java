package com.example.twelvethweekhomework.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
@Slf4j
public class ActiveProducer {
    @Resource
    private Queue testQueue;
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String message) {
        log.info("生产消息:{}", message);
        jmsMessagingTemplate.convertAndSend(testQueue, message);
    }


    @Resource
    private Topic testTopic;

    public void sendTopic(String msg) {
        log.info("发送Topic消息内容: {}", msg);
        this.jmsMessagingTemplate.convertAndSend(testTopic, msg);
    }
}

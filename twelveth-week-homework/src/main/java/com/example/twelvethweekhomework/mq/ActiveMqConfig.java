package com.example.twelvethweekhomework.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMqConfig {

    @Bean
    public Queue testQueue() {
        return new ActiveMQQueue("test.queue");
    }

    @Bean
    public Topic testTopic() {
        return new ActiveMQTopic("test.topic");
    }
}

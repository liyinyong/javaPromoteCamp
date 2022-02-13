package com.example.mymq.core;

import com.example.mymqapi.model.KmqMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KmqProducer {

    @Resource
    private KmqBroker broker;

    public boolean send(String topic, KmqMessage message) {
        Kmq kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return kmq.send(message);
    }
}

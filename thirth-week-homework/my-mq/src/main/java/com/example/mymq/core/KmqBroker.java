package com.example.mymq.core;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public final class KmqBroker { // Broker+Connection

    public static final int CAPACITY = 10000;

    private final Map<String, Kmq> kmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        kmqMap.putIfAbsent(name, new Kmq(name,CAPACITY));
    }

    public Kmq findKmq(String topic) {
        return this.kmqMap.get(topic);
    }
}

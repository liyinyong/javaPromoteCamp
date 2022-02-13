package com.example.mymq.core;

import com.example.mymqapi.model.KmqMessage;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new LinkedBlockingQueue(capacity);
        this.listQueue = new ArrayList<>(capacity);
        offset = new AtomicInteger(0);
    }

    private String topic;
    /**
     * 第一版
     */
    private int capacity;
    private LinkedBlockingQueue<KmqMessage> queue;
    /**
     * 第二版
     */
    private AtomicInteger offset;

    private List<KmqMessage> listQueue;

    public boolean send(KmqMessage message) {
        //return queue.offer(message);
        return listQueue.add(message);
    }

    public KmqMessage poll() {
        //return queue.poll();
        return listQueue.get(offset.get());
    }

    public boolean commit() {
        return listQueue.get(offset.get()).commit();
    }

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

}

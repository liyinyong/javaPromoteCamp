package com.example.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ReceiverRedisMessage {
    private CountDownLatch latch;

    @Autowired
    public ReceiverRedisMessage(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }


    public void receiveMessage(String jsonMsg) {
        log.info("[开始消费REDIS消息队列order数据...]");
        try {
            log.info("data:{}", jsonMsg);
            log.info("[消费REDIS消息队列order数据成功.]");
        } catch (Exception e) {
            log.error("[消费REDIS消息队列order数据失败，失败信息:{}]", e.getMessage());
        }
        latch.countDown();
    }
}

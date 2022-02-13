package com.example.mymqapi.api;

import com.example.mymqapi.model.KmqMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "127.0.0.1", path = "/mq")
public interface MyMqApi {
    @PostMapping("/send")
    Boolean sendMessage(@RequestParam("topic") String topic,
                        @RequestParam("message") KmqMessage message);

    @PostMapping("/get")
    KmqMessage getMessage(@RequestParam("topic") String topic);
}

package com.example.xaserver2.service;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "xa-server2", path = "/order")
public interface OrderApi {

    @GetMapping("/create")
    @Hmily
    String createOrder(int userId, int productId);
}

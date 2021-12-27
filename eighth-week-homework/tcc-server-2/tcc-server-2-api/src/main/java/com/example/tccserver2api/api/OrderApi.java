package com.example.tccserver2api.api;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tcc-server-2", path = "/order")
public interface OrderApi {

    @GetMapping("/create")
    @Hmily
    String createOrder(@RequestParam("userId") int userId,
                       @RequestParam("productId") int productId);
}

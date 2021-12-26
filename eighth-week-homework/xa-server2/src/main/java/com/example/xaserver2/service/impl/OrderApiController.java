package com.example.xaserver2.service.impl;

import com.example.xaserver2.service.OrderApi;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderApiController implements OrderApi {
    @Override
    @GetMapping("/create")
    @HmilyTCC(confirmMethod = "", cancelMethod = "")
    public String createOrder(int userId, int productId) {
        log.info("冻结库存");
        return "success";
    }

    public String confirmCreateOrder(int userId, int productId) {
        log.info("减少库存");
        return "success";
    }

    public String cancelCreateOrder(int userId, int productId) {
        log.info("恢复库存");
        return "success";
    }
}

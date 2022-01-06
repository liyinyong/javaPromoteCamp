package com.example.tccserver1.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.tccserver1.service.AccountBalanceService;
import com.example.tccserver1.service.AccountBalanceServiceImpl;
import com.example.tccserver2api.api.AccountBalanceApi;
import com.example.tccserver2api.dto.ExchangeDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class TestController {
    @Reference(version = "1.0.0")
    private AccountBalanceApi accountBalanceApi;
    @Resource
    private AccountBalanceService accountBalanceService;

    @GetMapping("/test")
    public void testDubboTCC() {
        Long orderId = System.currentTimeMillis();
        ExchangeDTO exchangeDTO = new ExchangeDTO();
        exchangeDTO.setUserId(1L);
        exchangeDTO.setOrderId(orderId);
        exchangeDTO.setAmountCNY(new BigDecimal("7"));
        exchangeDTO.setAmountUS(new BigDecimal("1"));
        accountBalanceService.exchangeAccountBalance(exchangeDTO);

        ExchangeDTO secondExchangeDTO = new ExchangeDTO();
        secondExchangeDTO.setUserId(2L);
        secondExchangeDTO.setOrderId(orderId);
        secondExchangeDTO.setAmountCNY(new BigDecimal("7"));
        secondExchangeDTO.setAmountUS(new BigDecimal("1"));
        accountBalanceApi.exchangeAccountBalance(secondExchangeDTO);
    }
}

package com.example.tccserver1.controller;

import com.example.tccserver2api.api.OrderApi;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestTccController {
    @Resource
    private OrderApi orderApi;

    @GetMapping("test/")
    @Transactional
    public void testCreateOrder() {

    }
}

package com.example.tccserver2api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeDTO {
    private Long orderId;
    private Long userId;
    private BigDecimal amountCNY;
    private BigDecimal amountUS;
}

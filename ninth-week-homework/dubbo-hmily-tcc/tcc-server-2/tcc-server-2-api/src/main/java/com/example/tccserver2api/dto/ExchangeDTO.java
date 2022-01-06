package com.example.tccserver2api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ExchangeDTO implements Serializable {
    private Long orderId;
    private Long userId;
    private BigDecimal amountCNY;
    private BigDecimal amountUS;
}

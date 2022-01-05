package com.example.tccserver2api.api;

import com.example.tccserver2api.dto.ExchangeDTO;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

public interface AccountBalanceApi {
    @Hmily
    void exchangeAccountBalance(ExchangeDTO exchangeDTO);
}

package com.example.tccserver1.service;

import com.example.tccserver2api.dto.ExchangeDTO;
import org.dromara.hmily.annotation.Hmily;

public interface AccountBalanceService {
    @Hmily
    void exchangeAccountBalance(ExchangeDTO exchangeDTO);
}

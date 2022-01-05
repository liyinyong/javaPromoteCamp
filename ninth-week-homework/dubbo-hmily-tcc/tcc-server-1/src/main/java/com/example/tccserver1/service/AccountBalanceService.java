package com.example.tccserver1.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.tccserver1.mapper.AccountBalanceDao;
import com.example.tccserver1.mapper.AccountBalanceFreezeDao;
import com.example.tccserver1.model.AccountBalance;
import com.example.tccserver1.model.AccountBalanceFreeze;
import com.example.tccserver2api.dto.ExchangeDTO;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountBalanceService {
    @Resource
    private AccountBalanceFreezeDao accountBalanceFreezeDao;
    @Resource
    private AccountBalanceDao accountBalanceDao;

    @HmilyTCC(confirmMethod = "confirmExchangeAccountBalance", cancelMethod = "cancelExchangeAccountBalance")
    @Transactional
    public void exchangeAccountBalance(ExchangeDTO exchangeDTO) {
        //增加人民币冻结金额
        AccountBalance accountBalance = accountBalanceDao.getByUserIdAndCurrency(exchangeDTO.getUserId(), (byte) 1);
        accountBalance.setFreezeNumber(accountBalance.getFreezeNumber().add(exchangeDTO.getAmountCNY()));
        accountBalanceDao.updateByPrimaryKeySelective(accountBalance);

        //增加冻结记录
        AccountBalanceFreeze accountBalanceFreeze = new AccountBalanceFreeze();
        accountBalanceFreeze.setUserId(exchangeDTO.getUserId());
        accountBalanceFreeze.setFreezeNumber(exchangeDTO.getAmountCNY());
        accountBalanceFreeze.setOrderId(exchangeDTO.getOrderId());
        accountBalanceFreeze.setAccountBalanceId(accountBalance.getId());
        accountBalanceFreezeDao.insertSelective(accountBalanceFreeze);
    }

    @Transactional
    public void confirmExchangeAccountBalance(ExchangeDTO exchangeDTO) {
        //更新人民币账号
        AccountBalance accountBalanceCNY = accountBalanceDao.getByUserIdAndCurrency(exchangeDTO.getUserId(), (byte) 1);
        accountBalanceCNY.setBalance(accountBalanceCNY.getBalance().subtract(exchangeDTO.getAmountCNY()));
        accountBalanceDao.updateByPrimaryKeySelective(accountBalanceCNY);
        //更新美元账号
        AccountBalance accountBalanceUS = accountBalanceDao.getByUserIdAndCurrency(exchangeDTO.getUserId(), (byte) 2);
        accountBalanceUS.setBalance(accountBalanceUS.getBalance().add(exchangeDTO.getAmountUS()));
        accountBalanceDao.updateByPrimaryKeySelective(accountBalanceUS);
    }

    @Transactional
    public void cancelExchangeAccountBalance(ExchangeDTO exchangeDTO) {
        AccountBalance accountBalance = accountBalanceDao.getByUserIdAndCurrency(exchangeDTO.getUserId(), (byte) 1);
        accountBalance.setFreezeNumber(accountBalance.getFreezeNumber().subtract(exchangeDTO.getAmountCNY()));
        accountBalanceDao.updateByPrimaryKeySelective(accountBalance);

        accountBalanceFreezeDao.deleteByOrderId(exchangeDTO.getOrderId());
    }
}

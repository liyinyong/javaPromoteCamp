package com.example.tccserver1.mapper;

import com.example.tccserver1.model.AccountBalanceFreeze;
import org.apache.ibatis.annotations.Param;

public interface AccountBalanceFreezeDao {
    int deleteByPrimaryKey(Long id);

    int insert(AccountBalanceFreeze record);

    int insertSelective(AccountBalanceFreeze record);

    AccountBalanceFreeze selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountBalanceFreeze record);

    int updateByPrimaryKey(AccountBalanceFreeze record);

    int deleteByOrderId(@Param("orderId") Long orderId);
}
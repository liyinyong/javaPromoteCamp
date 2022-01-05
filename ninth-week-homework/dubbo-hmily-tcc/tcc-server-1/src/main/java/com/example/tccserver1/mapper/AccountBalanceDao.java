package com.example.tccserver1.mapper;

import com.example.tccserver1.model.AccountBalance;
import org.apache.ibatis.annotations.Param;

public interface AccountBalanceDao {
    int deleteByPrimaryKey(Long id);

    int insert(AccountBalance record);

    int insertSelective(AccountBalance record);

    AccountBalance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountBalance record);

    int updateByPrimaryKey(AccountBalance record);

    AccountBalance getByUserIdAndCurrency(@Param("userId") Long userId, @Param("currency") byte currency);
}
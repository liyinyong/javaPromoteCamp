package com.example.tccserver2.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * account_balance
 * @author 
 */
@Data
public class AccountBalanceFreeze implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 账号id
     */
    private Long accountBalanceId;
    /**
     * 冻结金额
     */
    private BigDecimal freezeNumber;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
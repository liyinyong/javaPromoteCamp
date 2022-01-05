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
public class AccountBalance implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 币种, 1=人民币，2=美元
     */
    private Byte currency;

    /**
     * 剩余金额
     */
    private BigDecimal balance;

    /**
     * 冻结金额
     */
    private BigDecimal freezeNumber;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
package com.example.xaserver1.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order_info_0
 *
 * @author
 */
@Data
@Table(name = "order_info")
public class OrderInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 物流单号
     */
    private Long expressId;

    /**
     * 订单状态
     */
    private Byte state;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
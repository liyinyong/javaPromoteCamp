package com.example.xaserver1;

import com.example.xaserver1.mapper.OrderInfoMapper;
import com.example.xaserver1.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Transactional
    @ShardingSphereTransactionType(TransactionType.XA)
    public void addOrder() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(100L);
        orderInfo.setExpressId(1L);
        orderInfo.setPrice(BigDecimal.ONE);
        orderInfo.setPayTime(null);
        orderInfoMapper.insertSelective(orderInfo);
        log.info("插入数据：{}", orderInfo);
    }
}

package com.example.xaserver1;

import com.example.xaserver1.mapper.OrderInfoMapper;
import com.example.xaserver1.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @GetMapping("/testXa")
    @Transactional
    @ShardingSphereTransactionType(TransactionType.XA)
    public void testXa() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(100L);
        orderInfo.setExpressId(1L);
        orderInfo.setPrice(BigDecimal.ONE);
        orderInfo.setPayTime(null);
        orderInfoMapper.insertSelective(orderInfo);
        log.info("插入数据：{}", orderInfo);
    }

}

package com.example.eighthweekhomework;

import com.example.eighthweekhomework.mapper.OrderInfoMapper;
import com.example.eighthweekhomework.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@MapperScan(basePackages = "com.example.eighthweekhomework.mapper")
@Slf4j
public class EighthWeekHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EighthWeekHomeworkApplication.class, args);
    }

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Override
    public void run(String... args) throws Exception {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(100L);
        orderInfo.setExpressId(1L);
        orderInfo.setPrice(BigDecimal.ONE);
        orderInfo.setPayTime(null);
        orderInfoMapper.insertSelective(orderInfo);
        log.info("插入数据：{}", orderInfo);

        OrderInfo selectOrderInfo = orderInfoMapper.selectByPrimaryKey(orderInfo.getId());
        log.info("查询数据：{}", selectOrderInfo);

        selectOrderInfo.setState((byte) 2);
        selectOrderInfo.setPayTime(new Date());
        orderInfoMapper.updateByPrimaryKeySelective(selectOrderInfo);

        OrderInfo updateOrderInfo = orderInfoMapper.selectByPrimaryKey(orderInfo.getId());
        log.info("更新数据：{}", updateOrderInfo);

        orderInfoMapper.deleteByPrimaryKey(updateOrderInfo.getId());
        OrderInfo deleteOrderInfo = orderInfoMapper.selectByPrimaryKey(orderInfo.getId());
        log.info("删除数据：{}", deleteOrderInfo);
    }
}
